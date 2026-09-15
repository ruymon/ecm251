import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Checksum {
    private static final Charset CHARSET = StandardCharsets.ISO_8859_1;
    private static final int BYTE_MASK = 0xFF;

    public char calcularChecksum(char[] data) {
        int sum = 0;

        for (char character : data) {
            sum += character & BYTE_MASK;
        }

        return (char) twosComplement(sum & BYTE_MASK);
    }

    public char calcularChecksumDoArquivoTexto(Path inputFile, Path outputFile) throws IOException {
        char[] data = Files.readString(inputFile, CHARSET).toCharArray();
        char checksum = calcularChecksum(data);

        Files.writeString(outputFile, new String(data) + checksum, CHARSET);

        return checksum;
    }

    private int twosComplement(int value) {
        return (~value + 1) & BYTE_MASK;
    }
}
