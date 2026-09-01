import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadUserFile application = new ReadUserFile();

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Password: ");
        String password = scanner.next();

        application.openFile();

        if (application.validate(name, password)) {
            System.out.println("LOGIN SUCCESSFUL");
        } else {
            System.out.println("WRONG LOGIN AND/OR PASSWORD");
        }

        application.closeFile();
        scanner.close();
    }
}
