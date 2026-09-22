import java.util.Arrays;
import java.util.Date;

public class Auth {
    // Classroom demo account. Replace this method if the test requires a database.
    // This is not a real password storage system.
    public Session login(String username, char[] password) {
        if ("admin".equals(username) && Arrays.equals(password, new char[] {'1', '2', '3', '4'})) {
            return new Session(username, "Administrador", new Date());
        }
        return null;
    }
}
