# File access

`StudentTextFile` saves, loads, and searches student records with `Formatter` and `Scanner`, as in lesson 16. Semicolons separate fields so names containing spaces work. `try (...)` closes the files automatically, including when an error occurs.

`FileHelper` provides standalone generic text methods. `StudentObjectFile` is an optional extra: `Serializable` saves the complete student list, including its dates, to a binary file.

## Run

Open a terminal in this folder:

```sh
javac -encoding UTF-8 *.java
java Main
```

The example writes `demo-notes.txt`, `demo-students.txt`, and `demo-students.dat`, then reads them. Each run replaces those three demo files.

## Copy into your program

- For student records, copy `StudentTextFile.java` and `Student.java`. If using `01-starter`, keep its existing `Student.java`; the text helper works with it directly.
- Copy only `FileHelper.java` for generic text lines; it has no dependency on the student classes.
- For optional object saving, copy `StudentObjectFile.java` and this folder's `Student.java`, which implements `Serializable`.
- `Main.java` is only a demonstration.

## Student records

```java
try {
    StudentTextFile.save("students.txt", students);
    students = StudentTextFile.load("students.txt");

    Student found = StudentTextFile.findByRa("students.txt", "1001");
    JOptionPane.showMessageDialog(this, found == null ? "RA not found." : found.getName());
} catch (IOException exception) {
    JOptionPane.showMessageDialog(this, "File error: " + exception.getMessage());
}
```

Here, `students` is your existing `List<Student>`. This button-handler example needs imports for `java.io.IOException` and `javax.swing.JOptionPane`. A missing RA returns `null`; an unreadable or malformed file throws `IOException`.

The UTF-8 file has no header. Each line contains `RA;name;course;grade;date`, for example:

```text
1001;João Silva;Computer Engineering;8.5;1704067200000
```

The date is `Date.getTime()` (milliseconds since the Unix epoch); `new Date(value)` restores it. Grades use a decimal point regardless of the computer's language. Writing preserves the full `double` value; reading uses `Locale.US`. Semicolons and line breaks are rejected inside text fields before the existing file is overwritten. Student fields must be filled in, and grades must be finite numbers from 0 to 10. Malformed records report their line number.

`save` always overwrites the complete file. To add or remove a saved student, load the list, change it, and save it again. Saving an empty list produces an empty file. The text helper has no dependency on `FileHelper` or `Serializable`.

## Generic text lines

```java
try {
    FileHelper.writeLines("notes.txt", Arrays.asList("First line", "Second line"), false);
    FileHelper.writeLines("notes.txt", Arrays.asList("Another line"), true);

    for (String line : FileHelper.readLines("notes.txt")) {
        System.out.println(line);
    }
} catch (IOException exception) {
    JOptionPane.showMessageDialog(this, "File error: " + exception.getMessage());
}
```

This button-handler example also needs `java.util.Arrays`. In a console program, replace dialogs with `System.err.println(...)` as in `Main`.

`false` overwrites a text file; `true` appends lines. Every written line gets a line break. Text is UTF-8, including accented names. Empty files return an empty list; missing files throw an `IOException` that the caller handles.

## Optional object files

Call `StudentObjectFile.saveStudents("students.dat", students)` and `StudentObjectFile.loadStudents("students.dat")`. Catch both `IOException` and `ClassNotFoundException` when loading, as in `Main`. To add a saved student, load the list, call `add`, then save the whole list again. Do not append object streams to the same file. Only load object files produced by your own program; use text files for external input.

## Paths and the original lesson format

Relative paths such as `"notes.txt"` start in the folder where the program runs, not necessarily the folder containing the source. In NetBeans, this is normally the project folder. A subfolder in a path must already exist. To see the current folder, print `System.getProperty("user.dir")`.

If the exam specifically requires the lesson's whitespace-separated records, use `output.format("%s %s%n", ra, name)` when writing, then matching `input.next()` calls when reading. That format only supports single-word field values. If you write decimal numbers, use the same locale for `Formatter` and `Scanner`, such as `Locale.US`, so the decimal separator matches.
