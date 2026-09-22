import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

// Same convention as lesson18: public boolean testSomething(), with no arguments.
public class TestRunner {
    private final Object suite;

    public TestRunner(Object suite) {
        this.suite = suite;
    }

    public boolean runAll() {
        Method[] methods = suite.getClass().getDeclaredMethods();
        Arrays.sort(methods, Comparator.comparing(Method::getName));
        int total = 0;
        int passed = 0;

        for (Method method : methods) {
            if (method.getName().startsWith("test")
                    && Modifier.isPublic(method.getModifiers())
                    && method.getReturnType() == boolean.class
                    && method.getParameterCount() == 0) {
                total++;

                if (execute(method)) {
                    passed++;
                }
            }
        }

        System.out.println("Passed " + passed + " of " + total + " tests");

        if (total == 0) {
            System.out.println("No tests found. Use public boolean testName() methods.");
        }

        return total > 0 && passed == total;
    }

    private boolean execute(Method method) {
        try {
            boolean passed = (boolean) method.invoke(suite);
            System.out.println(method.getName() + ": " + passed);
            return passed;
        } catch (InvocationTargetException exception) {
            System.out.println(method.getName() + ": false (" + exception.getCause() + ")");
            return false;
        } catch (IllegalAccessException exception) {
            System.out.println(method.getName() + ": false (" + exception + ")");
            return false;
        }
    }

    public static void main(String[] args) {
        // CHANGE HERE: replace ChecksumTest with the class containing your tests.
        TestRunner runner = new TestRunner(new ChecksumTest());

        if (!runner.runAll()) {
            System.exit(1);
        }
    }
}
