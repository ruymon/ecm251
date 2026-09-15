import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ChecksumApplication {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    private final Checksum checksum = new Checksum();

    public void run(String[] args) {
        Path inputFile = Path.of(args.length > 0 ? args[0] : INPUT_FILE_NAME);
        Path outputFile = Path.of(args.length > 1 ? args[1] : OUTPUT_FILE_NAME);

        runWithKeyboard();
        runWithFiles(inputFile, outputFile);
    }

    private void runWithKeyboard() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the characters: ");
        char[] data = scanner.nextLine().toCharArray();

        System.out.println("Checksum: " + formatChecksum(checksum.calcularChecksum(data)));

        scanner.close();
    }

    private void runWithFiles(Path inputFile, Path outputFile) {
        try {
            char fileChecksum = checksum.calcularChecksumDoArquivoTexto(inputFile, outputFile);

            System.out.println("Checksum of " + inputFile + ": " + formatChecksum(fileChecksum));
            System.out.println("Data with checksum written to " + outputFile);
        } catch (IOException ioException) {
            System.err.println("Error processing file: " + ioException.getMessage());
            System.exit(1);
        }
    }

    private String formatChecksum(char value) {
        String hexadecimal = String.format("0x%02X", (int) value);

        return Character.isISOControl(value) ? hexadecimal : String.format("'%c' (%s)", value, hexadecimal);
    }
}
