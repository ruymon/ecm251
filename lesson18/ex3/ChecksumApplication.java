import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ChecksumApplication {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String CHECKSUM_OUTPUT_FILE_NAME = "output_checksum.txt";
    private static final String CRC_OUTPUT_FILE_NAME = "output_crc.txt";

    private final Checksum checksum = new Checksum();

    public void run(String[] args) {
        Path inputFile = Path.of(args.length > 0 ? args[0] : INPUT_FILE_NAME);
        Path checksumOutputFile = Path.of(args.length > 1 ? args[1] : CHECKSUM_OUTPUT_FILE_NAME);
        Path crcOutputFile = Path.of(args.length > 2 ? args[2] : CRC_OUTPUT_FILE_NAME);

        runWithKeyboard();
        runWithFiles(inputFile, checksumOutputFile, crcOutputFile);
    }

    private void runWithKeyboard() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the characters: ");
        char[] data = scanner.nextLine().toCharArray();

        System.out.println("Checksum: " + formatChecksum(checksum.calcularChecksum(data)));
        System.out.println("CRC: " + formatCrc(checksum.calcularCRC(data)));

        scanner.close();
    }

    private void runWithFiles(Path inputFile, Path checksumOutputFile, Path crcOutputFile) {
        try {
            char fileChecksum = checksum.calcularChecksumDoArquivoTexto(inputFile, checksumOutputFile);
            long fileCrc = checksum.calcularCRCDoArquivoTexto(inputFile, crcOutputFile);

            System.out.println("Checksum of " + inputFile + ": " + formatChecksum(fileChecksum));
            System.out.println("Data with checksum written to " + checksumOutputFile);
            System.out.println("CRC of " + inputFile + ": " + formatCrc(fileCrc));
            System.out.println("Data with CRC written to " + crcOutputFile);
        } catch (IOException ioException) {
            System.err.println("Error processing file: " + ioException.getMessage());
            System.exit(1);
        }
    }

    private String formatChecksum(char value) {
        String hexadecimal = String.format("0x%02X", (int) value);

        return Character.isISOControl(value) ? hexadecimal : String.format("'%c' (%s)", value, hexadecimal);
    }

    private String formatCrc(long value) {
        return String.format("0x%08X", value);
    }
}
