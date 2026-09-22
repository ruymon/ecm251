import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Checksum {
    private static final Charset CHARSET = StandardCharsets.ISO_8859_1;
    private static final int BYTE_MASK = 0xFF;
    private static final int CRC_BYTES = 4;
    private static final long CRC_POLYNOMIAL = 0xEDB88320L;
    private static final long CRC_INITIAL_VALUE = 0xFFFFFFFFL;
    private static final long CRC_FINAL_XOR = 0xFFFFFFFFL;

    public char calcularChecksum(char[] data) {
        int sum = 0;

        for (char character : data) {
            sum += character & BYTE_MASK;
        }

        return (char) twosComplement(sum & BYTE_MASK);
    }

    public char calcularChecksumDoArquivoTexto(Path inputFile, Path outputFile) throws IOException {
        char[] data = readCharacters(inputFile);
        char checksum = calcularChecksum(data);

        writeWithChecksum(outputFile, data, new char[] {checksum});

        return checksum;
    }

    public long calcularCRC(char[] data) {
        long crc = CRC_INITIAL_VALUE;

        for (char character : data) {
            crc ^= character & BYTE_MASK;

            for (int bit = 0; bit < Byte.SIZE; bit++) {
                boolean lowestBitSet = (crc & 1) == 1;

                crc >>>= 1;

                if (lowestBitSet) {
                    crc ^= CRC_POLYNOMIAL;
                }
            }
        }

        return crc ^ CRC_FINAL_XOR;
    }

    public long calcularCRCDoArquivoTexto(Path inputFile, Path outputFile) throws IOException {
        char[] data = readCharacters(inputFile);
        long crc = calcularCRC(data);

        writeWithChecksum(outputFile, data, toCharacters(crc));

        return crc;
    }

    private int twosComplement(int value) {
        return (~value + 1) & BYTE_MASK;
    }

    private char[] toCharacters(long crc) {
        char[] characters = new char[CRC_BYTES];

        for (int i = 0; i < CRC_BYTES; i++) {
            int shift = Byte.SIZE * (CRC_BYTES - 1 - i);

            characters[i] = (char) ((crc >>> shift) & BYTE_MASK);
        }

        return characters;
    }

    private char[] readCharacters(Path file) throws IOException {
        return Files.readString(file, CHARSET).toCharArray();
    }

    private void writeWithChecksum(Path file, char[] data, char[] checksum) throws IOException {
        Files.writeString(file, new String(data) + new String(checksum), CHARSET);
    }
}
