import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class FileHelper {
    // false replaces the file; true adds lines to the end.
    public static void writeLines(String fileName, List<String> lines, boolean append) throws IOException {
        try (FileOutputStream stream = new FileOutputStream(fileName, append);
                OutputStreamWriter writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8);
                Formatter output = new Formatter(writer)) {
            for (String line : lines) {
                output.format("%s%n", line);
            }

            output.flush();
            // Formatter records I/O errors instead of throwing them itself.
            if (output.ioException() != null) {
                throw output.ioException();
            }
        }
    }

    public static List<String> readLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();

        try (Scanner input = new Scanner(new File(fileName), "UTF-8")) {
            while (input.hasNextLine()) {
                lines.add(input.nextLine());
            }

            if (input.ioException() != null) {
                throw input.ioException();
            }
        }

        return lines;
    }

}
