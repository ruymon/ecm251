import java.util.Objects;

// These helpers return boolean, just like the tests in lesson18.
public class TestAssertions {
    public static boolean assertEquals(Object expected, Object actual) {
        if (Objects.equals(expected, actual)) {
            return true;
        }

        System.out.println("  Expected: " + expected + "; actual: " + actual);
        return false;
    }

    public static boolean assertEquals(long expected, long actual) {
        if (expected == actual) {
            return true;
        }

        System.out.println("  Expected: " + expected + "; actual: " + actual);
        return false;
    }

    // Decimal arithmetic can have tiny rounding differences. Use a tolerance.
    public static boolean assertEquals(double expected, double actual, double tolerance) {
        if (!Double.isFinite(tolerance) || tolerance < 0) {
            throw new IllegalArgumentException("Tolerance must be finite and nonnegative.");
        }

        if (expected == actual || Math.abs(expected - actual) <= tolerance) {
            return true;
        }

        System.out.println("  Expected: " + expected + "; actual: " + actual
                + "; tolerance: " + tolerance);
        return false;
    }

    public static boolean assertTrue(boolean condition) {
        if (!condition) {
            System.out.println("  Expected true; actual: false");
        }

        return condition;
    }

    public static boolean assertFalse(boolean condition) {
        if (condition) {
            System.out.println("  Expected false; actual: true");
        }

        return !condition;
    }
}
