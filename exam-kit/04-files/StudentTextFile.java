import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentTextFile {
    public static void save(String fileName, List<Student> students) throws IOException {
        // Check every record before opening the file, because opening replaces it.
        for (Student student : students) {
            if (student == null) {
                throw new IOException("A student cannot be null.");
            }
            checkText(student.getRa());
            checkText(student.getName());
            checkText(student.getCourse());
        }

        try (Formatter output = new Formatter(new File(fileName), "UTF-8", Locale.US)) {
            for (Student student : students) {
                // Double.toString preserves the grade without rounding and uses a decimal point.
                output.format("%s;%s;%s;%s;%d%n", student.getRa(), student.getName(), student.getCourse(),
                        Double.toString(student.getGrade()), student.getEnrollmentDate().getTime());
            }
            output.flush();
            if (output.ioException() != null) {
                throw output.ioException();
            }
        }
    }

    public static List<Student> load(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();
        int lineNumber = 0;

        try (Scanner input = new Scanner(new File(fileName), "UTF-8")) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                lineNumber++;
                if (line.split(";", -1).length != 5) {
                    throw new IOException("Line " + lineNumber + ": expected 5 fields separated by semicolons.");
                }

                try (Scanner record = new Scanner(line)) {
                    record.useDelimiter(";");
                    record.useLocale(Locale.US);
                    String ra = record.next();
                    String name = record.next();
                    String course = record.next();
                    double grade = record.nextDouble();
                    Date enrollmentDate = new Date(record.nextLong());
                    students.add(new Student(ra, name, course, grade, enrollmentDate));
                } catch (IllegalArgumentException | NoSuchElementException exception) {
                    throw new IOException("Line " + lineNumber + ": invalid student record.", exception);
                }
            }
            if (input.ioException() != null) {
                throw input.ioException();
            }
        }

        return students;
    }

    public static Student findByRa(String fileName, String ra) throws IOException {
        for (Student student : load(fileName)) {
            if (student.getRa().equals(ra)) {
                return student;
            }
        }
        return null;
    }

    private static void checkText(String value) throws IOException {
        if (value == null || value.contains(";") || value.contains("\n") || value.contains("\r")) {
            throw new IOException("Text fields cannot contain semicolons or line breaks.");
        }
    }
}
