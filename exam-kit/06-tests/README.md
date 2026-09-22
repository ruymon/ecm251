# Unit tests and checksums — lesson18

Copy this folder when you need tests without installing anything. It uses the
lesson's `public boolean testName()` methods and a small reflection-based runner.
There is no JUnit, Maven, Gradle, or additional library. Requires JDK 11 or newer.

From a terminal opened **inside this folder**:

```sh
javac *.java
java TestRunner
```

Expected result: `Passed 11 of 11 tests`. A failing test or an empty suite returns
exit code 1; a passing suite returns 0. These are ordinary boolean tests; `-ea` is
not needed. Do not compile all lesson folders together: their class names repeat.

In NetBeans, use a plain Java application with an empty/default package, copy
these four `.java` files into its source folder, and run `TestRunner.java` with
**Run File**. They belong in normal source files, not a JUnit test project.

## Files to copy

| File | Purpose |
| --- | --- |
| `TestRunner.java` | Finds and runs public no-argument boolean methods beginning with `test`. |
| `TestAssertions.java` | Reusable equality and boolean checks; prints expected and actual values. |
| `ChecksumTest.java` | Examples of normal, boundary, expected-error, and temporary-file tests. |
| `Checksum.java` | The checksum and CRC implementation from lesson18/ex3, unchanged. |

## Adapt it to the exam

1. Keep calculations and validation in an ordinary class, outside the Swing button listener.
2. Rename `ChecksumTest` to something such as `ProductTest`, including its filename.
3. Replace its `Checksum` field and test methods with your class and requirements.
4. Change `new ChecksumTest()` in `TestRunner.main` to `new ProductTest()`.
5. Add one normal case, one boundary case (zero, empty text, exact limit), and
   one invalid-input case for each important rule. Calculate expected values yourself.

Each test must be `public`, return `boolean`, start its name with `test`, and take
no parameters. A returned `false` or an unexpected exception fails the test. The
runner sorts names alphabetically; do not make tests depend on execution order.
For mutable classes, construct a new object inside each test to keep it independent.

Copyable checks inside a test method (replace the sample expressions):

```java
return TestAssertions.assertEquals("Ana", name);       // String/object equality
return TestAssertions.assertEquals(3, quantity);        // Integer or long equality
return TestAssertions.assertEquals(0.3, 0.1 + 0.2, 0.000001); // Decimal tolerance
return TestAssertions.assertTrue(total >= 0);
return TestAssertions.assertFalse(items.isEmpty());
```

These lines are alternatives: use one return per path. For several checks, save
each result in a boolean and return `first && second`. Object equality calls
`equals`; it does not compare arrays element by element. Use
`Arrays.equals(expected, actual)` inside `assertTrue` for arrays. Numeric values
should use the numeric overloads; the object overload considers `Integer` and
`Long` different types.

Copyable expected-exception test (replace `yourObject.yourMethod`):

```java
public boolean testInvalidValue() {
    try {
        yourObject.yourMethod(-1);
        return false; // No exception means this requirement was not satisfied.
    } catch (IllegalArgumentException exception) {
        return true;
    }
}
```

Catch the specific expected exception; catching every exception can hide bugs.
The provided checksum follows the lesson's behavior: a null array throws
`NullPointerException`; an empty array returns zero.

## Reuse the checksum methods

```java
Checksum checksum = new Checksum();
char result = checksum.calcularChecksum("Casa1".toCharArray()); // 'W'
long crc = checksum.calcularCRC("123456789".toCharArray());   // 0xCBF43926L
System.out.printf("Checksum: 0x%02X%n", (int) result);
System.out.printf("CRC: 0x%08X%n", crc);
```

The file methods accept input and output `Path` values and throw `IOException`.
They read ISO-8859-1, overwrite the output with the input plus the result, and
append raw bytes (one checksum byte or four CRC bytes, most significant first).
Use distinct input/output paths to preserve the original. This matches lesson18;
it is not a general Unicode file format. Checksum and CRC detect accidental
changes; they do not encrypt data or securely store passwords. The cryptography
folder provides encryption examples.

The file tests use temporary files and clean them up, so running them does not
change your exercise files.
