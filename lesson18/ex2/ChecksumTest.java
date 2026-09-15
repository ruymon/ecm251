import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ChecksumTest {
    private static final int BYTE_MASK = 0xFF;
    private static final String SAMPLE_TEXT = "Casa1";
    private static final char SAMPLE_CHECKSUM = 'W';

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
