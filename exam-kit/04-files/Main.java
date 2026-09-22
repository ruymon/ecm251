import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Text example: one string per line. Spaces and accents are preserved.
            FileHelper.writeLines("demo-notes.txt", Arrays.asList("Java class", "João Silva"), false);
            FileHelper.writeLines("demo-notes.txt", Arrays.asList("One more line"), true);

            System.out.println("Text file:");
            for (String line : FileHelper.readLines("demo-notes.txt")) {
                System.out.println(line);
            }

            // Structured text records: the primary student persistence example.
            List<Student> students = new ArrayList<>();
            students.add(new Student("1001", "Ana Silva", "Computing", 8.5, new Date()));
            students.add(new Student("1002", "João Souza", "Engineering", 7.0, new Date()));
            StudentTextFile.save("demo-students.txt", students);

            List<Student> savedStudents = StudentTextFile.load("demo-students.txt");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("\nStudents from the text file:");
            for (Student student : savedStudents) {
                System.out.printf("%s | %s | %s | %.1f | %s%n", student.getRa(), student.getName(),
                        student.getCourse(), student.getGrade(), dateFormat.format(student.getEnrollmentDate()));
            }

            Student found = StudentTextFile.findByRa("demo-students.txt", "1002");
            System.out.println(found == null ? "RA not found." : "Found: " + found.getName());

            // Optional extra: saving the same list as Java objects.
            StudentObjectFile.saveStudents("demo-students.dat", students);
            System.out.println("Students in object file: " + StudentObjectFile.loadStudents("demo-students.dat").size());
        } catch (IOException exception) {
            System.err.println("Could not read or write the file: " + exception.getMessage());
        } catch (ClassNotFoundException exception) {
            System.err.println("The saved object's class is not available: " + exception.getMessage());
        }
    }
}
