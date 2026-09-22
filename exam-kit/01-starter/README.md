# Registration starter

A student registration screen with a `JTable`, course `JComboBox`, menus and dialogs. It adds, updates, removes, and searches students. Clicking a table row fills the form; **Atualizar selecionado** saves the edit. **Limpar** clears the selection and form. The RA must be unique; the grade must be between 0 and 10. Both `7.5` and `7,5` work. Dates must be real dates in `dd/MM/yyyy` format.

```sh
javac -encoding UTF-8 *.java
java Main
```

| File | Purpose |
| --- | --- |
| `Main.java` | Starts the screen. |
| `StudentScreen.java` | Components, events, table/list operations. |
| `Student.java` | Data and validation. Rename to Product, Employee, etc. |
| `DateHelper.java` | Strict date parsing and display. Copy independently when needed. |
| `StudentTextFile.java` | Saves/loads text records with `Scanner` and `Formatter`; same helper as `04-files`. |

Use **Arquivo > Salvar arquivo...** to save the current list and **Abrir arquivo...** to load it. These use `JFileChooser`, handle cancellation and report file errors. Saving an existing file and replacing a nonempty list ask for confirmation. Saving is manual: use it before closing the program. An invalid file leaves the current list intact. The semicolon file format is described in [04-files](../04-files/README.md).

The `ArrayList<Student>` stores the actual objects. `DefaultTableModel` shows those objects. After changing the list, `refreshTable()` rebuilds the rows. Table cells are read-only so changes go through validation. The `selectedRow()` method converts the visible row index to the model index; this also works if you later enable sorting.

To adapt the program, change the model fields/constructor/getters, form fields, table column names, `saveStudent()`, `valueChanged()`, and `refreshTable()`. The model currently has getters only: editing replaces the selected object with a validated new object.

The initial date is today. `DateHelper` uses `SimpleDateFormat` because that is the style used in class. Its pattern uses **MM for month**, **mm for minute**, and **yyyy for year**. It rejects invalid dates and extra text. See the official [SimpleDateFormat reference](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/text/SimpleDateFormat.html) for pattern letters and parsing.

See [RECIPES.md](../RECIPES.md) to add login or translated labels. If your test only needs data in memory, remove `saveItem`, `openItem`, their menu/listener branches, and `saveFile()`/`openFile()`; then `StudentTextFile.java` is not needed.
