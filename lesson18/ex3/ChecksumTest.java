import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Random;
import java.util.zip.CRC32;

public class ChecksumTest {
    private static final int BYTE_MASK = 0xFF;
    private static final String SAMPLE_TEXT = "Casa1";
    private static final char SAMPLE_CHECKSUM = 'W';
    private static final String CRC_SAMPLE_TEXT = "123456789";
    private static final long CRC_SAMPLE_VALUE = 0xCBF43926L;
    private static final String CRC_SAMPLE_SUFFIX = new String(new char[] {0xCB, 0xF4, 0x39, 0x26});
    private static final long RANDOM_SEED = 42;
    private static final int RANDOM_DATA_LENGTH = 1024;

    private final Checksum checksum = new Checksum();

    public boolean testCalcularChecksum() {
        return checksum.calcularChecksum(SAMPLE_TEXT.toCharArray()) == SAMPLE_CHECKSUM;
    }

    public boolean testCalcularChecksumWithEmptyData() {
        return checksum.calcularChecksum(new char[0]) == 0;
    }

    public boolean testCalcularChecksumDiscardsOverflow() {
        char[] data = {0x80, 0x80};

        return checksum.calcularChecksum(data) == 0;
    }

    public boolean testCalcularChecksumMakesTotalSumZero() {
        char[] data = "Unit tests for the Checksum class".toCharArray();
        int total = checksum.calcularChecksum(data);

        for (char character : data) {
            total += character;
        }

        return (total & BYTE_MASK) == 0;
    }

    public boolean testCalcularChecksumDoArquivoTexto() throws IOException {
        Path inputFile = createTempFile(SAMPLE_TEXT);
        Path outputFile = createTempFile("");

        return checksum.calcularChecksumDoArquivoTexto(inputFile, outputFile) == SAMPLE_CHECKSUM;
    }

    public boolean testCalcularChecksumDoArquivoTextoAppendsChecksum() throws IOException {
        Path inputFile = createTempFile(SAMPLE_TEXT);
        Path outputFile = createTempFile("");

        checksum.calcularChecksumDoArquivoTexto(inputFile, outputFile);

        return readFile(outputFile).equals(SAMPLE_TEXT + SAMPLE_CHECKSUM);
    }

    public boolean testCalcularChecksumDoArquivoTextoWithMissingFile() throws IOException {
        Path missingFile = createMissingFile();
        Path outputFile = createTempFile("");

        try {
            checksum.calcularChecksumDoArquivoTexto(missingFile, outputFile);
            return false;
        } catch (NoSuchFileException exception) {
            return true;
        }
    }

    public boolean testCalcularCRC() {
        return checksum.calcularCRC(CRC_SAMPLE_TEXT.toCharArray()) == CRC_SAMPLE_VALUE;
    }

    public boolean testCalcularCRCWithEmptyData() {
        return checksum.calcularCRC(new char[0]) == 0;
    }

    public boolean testCalcularCRCMatchesReferenceImplementation() {
        byte[] bytes = new byte[RANDOM_DATA_LENGTH];
        CRC32 reference = new CRC32();

        new Random(RANDOM_SEED).nextBytes(bytes);
        reference.update(bytes);

        char[] data = new String(bytes, StandardCharsets.ISO_8859_1).toCharArray();

        return checksum.calcularCRC(data) == reference.getValue();
    }

    public boolean testCalcularCRCDoArquivoTexto() throws IOException {
        Path inputFile = createTempFile(CRC_SAMPLE_TEXT);
        Path outputFile = createTempFile("");

        return checksum.calcularCRCDoArquivoTexto(inputFile, outputFile) == CRC_SAMPLE_VALUE;
    }

    public boolean testCalcularCRCDoArquivoTextoAppendsCRC() throws IOException {
        Path inputFile = createTempFile(CRC_SAMPLE_TEXT);
        Path outputFile = createTempFile("");

        checksum.calcularCRCDoArquivoTexto(inputFile, outputFile);

        return readFile(outputFile).equals(CRC_SAMPLE_TEXT + CRC_SAMPLE_SUFFIX);
    }

    public boolean testCalcularCRCDoArquivoTextoWithMissingFile() throws IOException {
        Path missingFile = createMissingFile();
        Path outputFile = createTempFile("");

        try {
            checksum.calcularCRCDoArquivoTexto(missingFile, outputFile);
            return false;
        } catch (NoSuchFileException exception) {
            return true;
        }
    }

    private Path createTempFile(String content) throws IOException {
        Path file = Files.createTempFile("checksum", ".txt");

        file.toFile().deleteOnExit();
        Files.writeString(file, content, StandardCharsets.ISO_8859_1);

        return file;
    }

    private Path createMissingFile() throws IOException {
        Path file = Files.createTempFile("checksum", ".txt");

        Files.delete(file);

        return file;
    }

    private String readFile(Path file) throws IOException {
        return Files.readString(file, StandardCharsets.ISO_8859_1);
    }

    public static void main(String[] args) {
        TestRunner runner = new TestRunner(new ChecksumTest());

        if (!runner.runAll()) {
            System.exit(1);
        }
    }
}
