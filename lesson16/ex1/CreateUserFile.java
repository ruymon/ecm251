import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class CreateUserFile {
    private static final String FILE_NAME = "users.txt";

    private Formatter output;

    public void openFile() {
        try {
            output = new Formatter(FILE_NAME);
        } catch (SecurityException securityException) {
            System.err.println("You do not have write access to this file.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error creating file.");
            System.exit(1);
        }
    }

    public void addRecords() {
        Scanner input = new Scanner(System.in);

        System.out.println("To terminate input, type the end-of-file indicator when you are prompted to enter input.");
        System.out.println("On UNIX/Linux/Mac OS X type <ctrl> d then press Enter.");
        System.out.println("On Windows type <ctrl> z then press Enter.");
        System.out.print("Enter name <SPACE> password <ENTER>\n? ");

        while (input.hasNext()) {
            String name = input.next();
            String password = input.next();

            output.format("%s %s%n", name, password);
            System.out.print("? ");
        }

        input.close();
    }

    public void closeFile() {
        if (output != null) {
            output.close();
        }
    }
}
