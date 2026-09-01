import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadUserFile {
    private static final String FILE_NAME = "../ex1/users.txt";

    private Scanner input;

    public void openFile() {
        try {
            input = new Scanner(new File(FILE_NAME));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public boolean validate(String name, String password) {
        while (input.hasNext()) {
            String fileName = input.next();
            String filePassword = input.next();

            if (fileName.equals(name) && filePassword.equals(password)) {
                return true;
            }
        }

        return false;
    }

    public void closeFile() {
        if (input != null) {
            input.close();
        }
    }
}
