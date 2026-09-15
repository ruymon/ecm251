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

    public static void main(String[] args) {
        TestRunner runner = new TestRunner(new ChecksumTest());

        if (!runner.runAll()) {
            System.exit(1);
        }
    }
}
