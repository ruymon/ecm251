public class Main {
    public static void main(String[] args) {
        CreateUserFile application = new CreateUserFile();

        application.openFile();
        application.addRecords();
        application.closeFile();
    }
}
