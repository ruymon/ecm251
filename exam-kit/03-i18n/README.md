# Internationalization: Portuguese and English

```sh
javac -encoding UTF-8 *.java
java Main
```

Use the **Idioma / Language** menu. Labels, window title, greeting, error dialogs, date format and decimal format change. Text already entered in the field remains unchanged.

Copy `LanguageScreen.java` and all three `Messages*.properties` files. `Main.java` is only the starting point. Every translated text uses the same key in each language file. `Messages.properties` supplies a default English fallback.

The files use ASCII plus `\uXXXX` escapes where needed, so they do not depend on the editor's accent encoding. `ResourceBundle.getBundle("Messages", locale)` looks for them at the classpath root. Keep them beside the compiled classes; in NetBeans, copy them into `src`. The name is **Messages**, without `.properties` or the language suffix.

To translate another screen, keep labels/buttons as fields, add matching property keys, and update their text in a `loadLanguage(Locale locale)` method. Pass the chosen `Locale` into the next screen's constructor when changing screens, as in lesson15/ex2. `DateFormat` and `NumberFormat` use that same locale. `MessageFormat` replaces `{0}` with the person's name.

`new Locale("pt", "BR")` also compiles with Java 17; some original exercises use the newer `Locale.of`. Dates and numbers here are display examples; they are not editable numeric/date inputs.
