public class Checksum {
    private static final int BYTE_MASK = 0xFF;

    public char calcularChecksum(char[] data) {
        int sum = 0;

        for (char character : data) {
            sum += character & BYTE_MASK;
        }

        return (char) twosComplement(sum & BYTE_MASK);
    }

    private int twosComplement(int value) {
        return (~value + 1) & BYTE_MASK;
    }
}
