# Offline login, icons and dates

```sh
javac -encoding UTF-8 *.java
java Main
```

Use **admin / 1234**. Empty fields and incorrect credentials show a dialog. The checkbox shows/hides the password. Successful login passes a `Session` to `WelcomeScreen`; **Trocar usuario** returns to login. The displayed date is the current login time, not a stored previous access.

Copy the five `.java` files and **both PNG files**. The PNGs are the icons already used in lesson 14. `getResource("/lock.png")` loads from the classpath root. With these terminal commands, that is the same folder as the classes. In NetBeans, copy both PNGs directly into the source root (`src`) so they are included in the build.

- Change the sample username/password and returned user name in `Auth.login`.
- Change `new WelcomeScreen(session)` in `LoginScreen.login` to open your own screen.
- Add fields/getters to `Session` if you need to pass more user data between screens.
- Read passwords with `getPassword()`, which returns `char[]`; `Arrays.equals` compares their contents.

The fixed account is a classroom shortcut to work without MySQL. It is not a real password storage system. A database requirement would need a different `Auth` implementation plus the database/driver from class. See [RECIPES.md](../RECIPES.md) for the JDBC pattern.
