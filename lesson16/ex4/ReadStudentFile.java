import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadStudentFile {
    private static final String FILE_NAME = "../ex3/students.txt";

    private Scanner input;

    public void openFile() throws FileNotFoundException {
        input = new Scanner(new File(FILE_NAME));
    }

    public Student findStudent(String ra) {
        while (input.hasNext()) {
            String fileRa = input.next();
            String name = input.next();
            String surname = input.next();
            double p1 = input.nextDouble();
            double p2 = input.nextDouble();
            double p3 = input.nextDouble();
            double p4 = input.nextDouble();

            if (fileRa.equals(ra)) {
                return new Student(fileRa, name, surname, p1, p2, p3, p4);
            }
        }

        return null;
    }

    public void closeFile() {
        if (input != null) {
            input.close();
        }
    }
}
