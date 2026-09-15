import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    private static final String TEST_METHOD_PREFIX = "test";

    private final Object suite;

    public TestRunner(Object suite) {
        this.suite = suite;
    }

    public boolean runAll() {
        List<Method> tests = findTests();
        int passed = 0;

        for (Method test : tests) {
            if (execute(test)) {
                passed++;
            }
        }

        System.out.println("Passed " + passed + " of " + tests.size() + " tests");

        return passed == tests.size();
    }

    private List<Method> findTests() {
        return Arrays.stream(suite.getClass().getDeclaredMethods())
                .filter(method -> method.getName().startsWith(TEST_METHOD_PREFIX))
                .filter(method -> method.getReturnType() == boolean.class)
                .sorted(Comparator.comparing(Method::getName))
                .toList();
    }

    private boolean execute(Method test) {
        try {
            boolean passed = (boolean) test.invoke(suite);

            System.out.println(test.getName() + ": " + passed);

            return passed;
        } catch (InvocationTargetException exception) {
            System.out.println(test.getName() + ": false (" + exception.getCause() + ")");

            return false;
        } catch (IllegalAccessException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
