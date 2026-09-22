import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// Optional extra: binary Java object files. Student must implement Serializable.
public class StudentObjectFile {
    // Object files store the complete list, so saving always replaces the file.
    public static void saveStudents(String fileName, List<Student> students) throws IOException {
        try (FileOutputStream stream = new FileOutputStream(fileName);
                ObjectOutputStream output = new ObjectOutputStream(stream)) {
            output.writeObject(new ArrayList<>(students));
        }
    }

    public static List<Student> loadStudents(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream stream = new FileInputStream(fileName);
                ObjectInputStream input = new ObjectInputStream(stream)) {
            Object saved = input.readObject();

            if (!(saved instanceof List<?>)) {
                throw new IOException("The file does not contain a student list.");
            }

            List<Student> students = new ArrayList<>();
            for (Object item : (List<?>) saved) {
                if (!(item instanceof Student)) {
                    throw new IOException("The file contains an invalid student.");
                }
                students.add((Student) item);
            }

            return students;
        }
    }
}
