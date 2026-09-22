# Java exam kit

Start with **`01-starter`** for a registration program, or **`00-window`** for the smallest possible screen. Copy the chosen folder before adapting it to the test requirements.

Everything runs offline with a JDK (Java 17 or newer is a safe common target). There are no packages, external libraries, build scripts, or downloads. The Java files use the lessons' style: ordinary classes, private fields, constructors/getters, Swing, `ActionListener`, and small methods. UI labels are mostly Portuguese; the guides are English.

## Find the code you need

| If the requirement says… | Start here | What to copy or change |
| --- | --- | --- |
| Create a window with fields and buttons | [00-window](00-window) | `Main.java` and `ExampleScreen.java` |
| Register/list/edit/delete/search/save records | [01-starter](01-starter/README.md) | Working student registration program with text file storage |
| Use JTable, JComboBox, JMenu, dialogs | [01-starter](01-starter/README.md) | `StudentScreen.java`: table model, selection, menus, validation |
| Login, password field, icons, change screens | [02-login](02-login/README.md) | Login + session + welcome screen; demo account **admin / 1234** |
| Read/format/validate dates | [01-starter](01-starter/DateHelper.java) | `DateHelper.java`; login also shows a timestamp |
| Switch Portuguese/English | [03-i18n](03-i18n/README.md) | `LanguageScreen.java` and all `Messages*.properties` files |
| Save/read/search a text file | [04-files](04-files/README.md) | `StudentTextFile.java` for records; `FileHelper.java` for text lines |
| Encrypt/decrypt, use AES/RSA, save keys | [05-crypto](05-crypto/README.md) | Chosen helper + the matching calls from `Main.java` |
| Unit tests, checksum, CRC | [06-tests](06-tests/README.md) | `TestRunner`, `TestAssertions`, sample tests and `Checksum` |
| Combine examples or use NetBeans | [RECIPES.md](RECIPES.md) | Exact integration steps and short copyable patterns |

## Run an example

Open a terminal **inside one example folder**:

```sh
javac -encoding UTF-8 *.java
java Main
```

For `06-tests`, run `java TestRunner` instead. These commands also work in Windows Command Prompt. In PowerShell, use `javac -encoding UTF-8 (Get-ChildItem *.java).Name` if its wildcard is not expanded.

Compile one example at a time. They intentionally repeat names such as `Main` and `Student`, just like the lesson exercises. Keep only one version of each class when combining examples. Copy `.java`, `.properties`, and `.png` files to the pen drive; generated `.class` files are optional because you can recompile on the classroom computer.

For a minimal new program, `00-window` is only two files. Change the window title, add your fields/buttons, and put the button logic inside `actionPerformed`. `Main` uses `SwingUtilities.invokeLater` to open the screen on Swing's event thread; leave that small block as it is.

## What was used from the lessons

- Lessons 6–7: simple model objects with private fields and getters.
- Lessons 11 and 13: `JFrame implements ActionListener`, layout managers, direct component construction. This repo's lesson 13 contains ordinary Java screens rather than NetBeans `.form` files.
- Lessons 14–15: `LoginScreen`, `Auth`, `Session`, icons loaded as resources, `Date`/formatters, `Locale` and `ResourceBundle`.
- Lesson 16: `Scanner`/`Formatter` and student records. The new record example uses semicolons so full names can contain spaces. Object serialization is clearly marked as an optional extra.
- Lesson 17: the existing helper names, byte arrays, Dummy/AES/RSA, and key files. The crypto guide explains its simpler RSA size limit and different key-file format.
- Lesson 18: boolean `test...()` methods and a plain Java runner. No JUnit setup is needed to match these exercises.

There is no `lesson12` folder in this repository; its listed Swing topics are covered using the patterns in later lessons. The offline login uses a fixed demo account. If the test explicitly requires the MySQL login from class, the original `lesson14` and `lesson15/ex2` contain the JDBC code; those examples need a database and driver, unlike this kit.

## Before leaving for the test

1. Copy this entire `exam-kit` folder to the pen drive, along with the lesson exercises you want.
2. Open one GUI example and run `06-tests` on the computer you will use, if possible.
3. Keep icons and translation files beside the compiled classes (NetBeans instructions are in `RECIPES.md`).
4. During the test, rename classes and fields to match the requested problem, then adjust validation and calculations.
