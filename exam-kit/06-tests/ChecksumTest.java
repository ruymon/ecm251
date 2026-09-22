import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ChecksumTest {
    private final Checksum checksum = new Checksum();

    // Normal case: use an expected result known independently of the method.
    public boolean testChecksumKnownValue() {
        return TestAssertions.assertEquals('W', checksum.calcularChecksum("Casa1".toCharArray()));
    }

    // Boundary case: an empty array is valid input.
    public boolean testChecksumEmptyInput() {
        return TestAssertions.assertEquals(0, checksum.calcularChecksum(new char[0]));
    }

    public boolean testChecksumOverflow() {
        return TestAssertions.assertEquals(0, checksum.calcularChecksum(new char[] {0x80, 0x80}));
    }

    public boolean testChecksumUsesLowByte() {
        return TestAssertions.assertEquals(255, checksum.calcularChecksum(new char[] {0x0101}));
    }

    public boolean testChecksumMakesTotalZero() {
        char[] data = "Test".toCharArray();
        int sum = checksum.calcularChecksum(data);

        for (char character : data) {
            sum += character & 0xFF;
        }

        return TestAssertions.assertTrue((sum & 0xFF) == 0);
    }

    // Expected-exception pattern: the test FAILS if the method does not throw.
    public boolean testChecksumRejectsNull() {
        try {
            checksum.calcularChecksum(null);
            return false;
        } catch (NullPointerException exception) {
            return true;
        }
    }

    public boolean testCrcKnownValue() {
        return TestAssertions.assertEquals(0xCBF43926L, checksum.calcularCRC("123456789".toCharArray()));
    }

    public boolean testCrcEmptyInput() {
        return TestAssertions.assertEquals(0, checksum.calcularCRC(new char[0]));
    }

    public boolean testChecksumFile() throws IOException {
        Path input = createTempFile("Casa1");
        Path output = createTempFile("");

        try {
            char result = checksum.calcularChecksumDoArquivoTexto(input, output);
            boolean correctValue = TestAssertions.assertEquals('W', result);
            boolean correctFile = TestAssertions.assertEquals("Casa1W", readFile(output));
            return correctValue && correctFile;
        } finally {
            Files.deleteIfExists(input);
            Files.deleteIfExists(output);
        }
    }

    public boolean testCrcFile() throws IOException {
        Path input = createTempFile("123456789");
        Path output = createTempFile("");

        try {
            long result = checksum.calcularCRCDoArquivoTexto(input, output);
            String suffix = new String(new char[] {0xCB, 0xF4, 0x39, 0x26});
            boolean correctValue = TestAssertions.assertEquals(0xCBF43926L, result);
            boolean correctFile = TestAssertions.assertEquals("123456789" + suffix, readFile(output));
            return correctValue && correctFile;
        } finally {
            Files.deleteIfExists(input);
            Files.deleteIfExists(output);
        }
    }

    public boolean testMissingFile() throws IOException {
        Path missing = createTempFile("");
        Path output = createTempFile("");
        Files.delete(missing);

        try {
            checksum.calcularChecksumDoArquivoTexto(missing, output);
            return false;
        } catch (NoSuchFileException exception) {
            return true;
        } finally {
            Files.deleteIfExists(output);
        }
    }

    private Path createTempFile(String content) throws IOException {
        Path file = Files.createTempFile("exam-checksum-", ".txt");
        file.toFile().deleteOnExit();
        Files.writeString(file, content, StandardCharsets.ISO_8859_1);
        return file;
    }

    private String readFile(Path file) throws IOException {
        return Files.readString(file, StandardCharsets.ISO_8859_1);
    }
}
