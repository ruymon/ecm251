import java.io.FileNotFoundException;
import java.util.Formatter;

public class CreateStudentFile {
    private static final String FILE_NAME = "students.txt";

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

    public void addRecord(Student student) {
        output.format("%s %s %s %.1f %.1f %.1f %.1f%n", student.getRa(), student.getName(),
                student.getSurname(), student.getP1(), student.getP2(), student.getP3(), student.getP4());
        output.flush();
    }

    public void closeFile() {
        if (output != null) {
            output.close();
        }
    }
}
