# Copy-and-paste guide

## NetBeans, without extra setup

1. Create a **Java with Ant > Java Application** project, or use the teacher's existing plain Java project. NetBeans supplies the project files; you do not need to write a build configuration.
2. Copy one example's `.java` files into its source folder (`src`). Use the default package for these unchanged examples. Remove a generated duplicate `Main.java` if necessary.
3. Copy `.png` and `.properties` files into `src` as well, at its root. Run `Main.java` (or `TestRunner.java`) with **Run File**.

If the teacher requires a package such as `prova`, put `package prova;` as the first line in **every** Java file and move those Java files into `src/prova`. Keep PNGs/properties at the source root: the kit uses absolute icon paths such as `/lock.png` and the root bundle name `Messages`.

The kit is plain source code, like this repo's lesson 13. It does not include `.form` files for the visual designer. If the test requires the **GUI Builder**, create a **JFrame Form**, drag components onto it, and name them to match the example. Put custom methods outside generated `initComponents()`. In a button's generated handler, call the example's method:

```java
private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    saveStudent(false);
}
```

Copy the model/helper classes as normal Java classes. Let the designer create component fields/layout/listeners; do not paste a whole example constructor into generated code or add the same listener twice. The examples' single `actionPerformed` method shows which helper each button should call.

Official reference: [NetBeans Java application workflow](https://netbeans.apache.org/tutorial/main/kb/docs/java/javase-intro/).

## Put login before the registration screen

1. Copy `01-starter` as your new project folder.
2. Add `Auth.java`, `Session.java`, `LoginScreen.java`, and `lock.png` from `02-login`.
3. In your existing `Main.java`, replace `new StudentScreen();` with `new LoginScreen();`.
4. In `LoginScreen.login()`, replace `new WelcomeScreen(session);` with `new StudentScreen();`. Keep the following `dispose()` to close login.

This is a complete login → registration → save/load program. Do not copy the second `Main.java`. `WelcomeScreen` and `user.png` are not needed for this combination. To show the logged-in name, change the registration constructor to `StudentScreen(Session session)`, call it with `new StudentScreen(session)`, and change its first line to:

```java
super("Cadastro - " + session.getName());
```

## Add translated labels

Copy `Messages*.properties` from `03-i18n`, then add keys for your own screen to **all** language files. Use the menu/listener pattern in `LanguageScreen` to call `loadLanguage` again when changing the language.

```java
// Fields in your screen; imports: java.util.Locale and java.util.ResourceBundle
private Locale locale = new Locale("pt", "BR");
private ResourceBundle bundle;

private void loadLanguage(Locale locale) {
    this.locale = locale;
    bundle = ResourceBundle.getBundle("Messages", locale);
    setTitle(bundle.getString("screen.title"));
    // Example with a new key you must add to each properties file:
    addButton.setText(bundle.getString("button.add"));
    pack();
}
```

Call this method **after** creating the components. Keep labels as fields if you need to translate them later. Add `Locale locale` as a constructor parameter to carry the chosen language to another screen; see the original `lesson15/ex2` for that complete pattern. Do not translate the internal values used to identify records.

## Common Swing operations

These are individual alternatives to paste inside your screen's methods, with the appropriate `javax.swing` imports. The component names refer to fields in `StudentScreen`.

```java
String name = nameField.getText().trim();
nameField.setText("");
nameField.requestFocusInWindow();

String course = (String) courseBox.getSelectedItem();
int courseIndex = courseBox.getSelectedIndex();
courseBox.setSelectedIndex(0);
courseBox.addItem("Outro curso");

// There are five columns in the starter: RA, name, course, grade, date.
model.addRow(new Object[] {"1001", "Ana", "Computacao", 8.0, "22/09/2026"});
model.setValueAt("Ana Lima", 0, 1); // row 0, column 1
model.removeRow(0);
model.setRowCount(0);

int row = table.getSelectedRow(); // -1 means no selection
if (row != -1) {
    row = table.convertRowIndexToModel(row);
    String ra = model.getValueAt(row, 0).toString();
}
```

The table examples show the API only. In the starter, update `students` first and call `refreshTable()` so the model objects and display stay synchronized. `JScrollPane(table)` makes the table header visible.

```java
JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
JOptionPane.showMessageDialog(this, "Valor invalido.", "Erro", JOptionPane.ERROR_MESSAGE);

String value = JOptionPane.showInputDialog(this, "Digite um valor:");
if (value == null) {
    return; // User cancelled; do not call trim() or parse on null.
}

int answer = JOptionPane.showConfirmDialog(this, "Deseja continuar?",
        "Confirmar", JOptionPane.YES_NO_OPTION);
if (answer == JOptionPane.YES_OPTION) {
    // Perform the requested operation here.
}
```

For a custom modal dialog, paste this inside a `JFrame` method. It closes only the dialog:

```java
// Imports: javax.swing.JDialog, JLabel, JButton; java.awt.FlowLayout
JDialog dialog = new JDialog(this, "Detalhes", true);
dialog.setLayout(new FlowLayout());
dialog.add(new JLabel("Conteudo da sua janela"));
JButton closeButton = new JButton("Fechar");
closeButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent event) {
        dialog.dispose();
    }
});
dialog.add(closeButton);
dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
dialog.pack();
dialog.setLocationRelativeTo(this);
dialog.setVisible(true);
```

## Input and calculations

Keep your calculation in a model/helper method so it is easy to test. Convert text in the button handler and catch conversion errors there:

```java
try {
    double grade = Double.parseDouble(gradeField.getText().trim().replace(',', '.'));
    if (!Double.isFinite(grade) || grade < 0 || grade > 10) {
        throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
    }
    JOptionPane.showMessageDialog(this, "Nota: " + grade);
} catch (NumberFormatException exception) {
    JOptionPane.showMessageDialog(this, "Digite um numero valido.");
} catch (IllegalArgumentException exception) {
    JOptionPane.showMessageDialog(this, exception.getMessage());
}
```

Use `Integer.parseInt` for integers. The decimal shortcut accepts `7,5` or `7.5`, not thousands separators. Compare string values with `.equals(...)`, not `==`. For averages use floating-point division, for example `(p1 + p2) / 2.0`.

## If the teacher specifically requires JDBC

The offline login does not require a database. The original `lesson14/Database.java` shows the connection and `lesson14/Auth.java` shows the complete query/update flow. For a database version, use the schema and credentials specified in the test and add the JDBC driver to the project classpath. A driver by itself does not provide a running database.

The reusable query pattern is:

```java
// Imports: java.sql.Connection, PreparedStatement, ResultSet, SQLException
// This method needs a Database class configured for the test's database.
public boolean usernameExists(String username) throws SQLException {
    String sql = "SELECT username FROM users WHERE username = ?";
    try (Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, username);
        try (ResultSet result = statement.executeQuery()) {
            return result.next();
        }
    }
}
```

Catch `SQLException` in the screen to show an error dialog. Set each `?` parameter with `setString`, `setInt`, etc.; parameter indexes start at **1**. Use `executeQuery()` for SELECT and `executeUpdate()` for INSERT/UPDATE/DELETE. The original MySQL connector jar is already present in `lesson15/ex2/lib` if you need to take it on the pen drive.

## Quick fixes

| Problem | Check |
| --- | --- |
| Duplicate class `Main` / `Student` | Compile one example folder; keep one class of each name when combining. |
| PNG resource is null | Include PNGs at the classpath root; keep the leading `/` in the icon path. |
| `MissingResourceException` | Include all `Messages*.properties` at the classpath root; check key spelling. |
| A text file cannot be found | Relative paths start at `System.getProperty("user.dir")`; use the starter's file chooser to select a file. |
| Selected row is `-1` | Select a row first; handle no selection before editing/deleting. |
| Cipher output looks broken as text | Display it with Base64; decode Base64 before decrypting. |
| Previously encrypted data no longer decrypts | Use the same saved key and the whole ciphertext, including the AES IV. |
| Test runner finds no tests | Use `public boolean testName()` with no arguments. |
