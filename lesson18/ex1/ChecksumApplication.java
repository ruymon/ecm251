import java.util.Scanner;

public class ChecksumApplication {
    private final Checksum checksum = new Checksum();

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the characters: ");
        char[] data = scanner.nextLine().toCharArray();
        char result = checksum.calcularChecksum(data);

        System.out.println("Checksum: " + formatChecksum(result));

        scanner.close();
    }

    private String formatChecksum(char value) {
        String hexadecimal = String.format("0x%02X", (int) value);

        return Character.isISOControl(value) ? hexadecimal : String.format("'%c' (%s)", value, hexadecimal);
    }
}
