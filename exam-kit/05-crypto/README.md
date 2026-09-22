# Cryptography helpers — Lesson 17

Run from this folder with JDK 11 or newer:

```sh
javac -encoding UTF-8 *.java
java Main
java Main "Minha mensagem com acentuação"
```

The demo creates four key files and `texto_cifrado.aes` in the current directory.
It reuses existing keys and replaces the encrypted demo file on each run.
Keep the key files: generating a new key will not decrypt data saved with the old one.

## Copy only what you need

| Requirement | Copy | Important methods |
| --- | --- | --- |
| Simple reversible exercise | `CryptoDummy.java` | `geraChave`, `geraCifra`, `geraDecifra` |
| One shared key for encryption/decryption | `CryptoAES.java` | `geraChave`, `geraCifra`, `geraDecifra` |
| Public/private keys, small messages | `CryptoRSA.java` | `geraParDeChaves`, `geraCifra`, `geraDecifra` |
| Working calls and error handling | Relevant section of `Main.java` | `getTextoCifrado`, `getTextoDecifrado` |

These classes have no package and need no library. Add the chosen helper to your
project's source folder. Add your project's `package` line if it uses a package.
The method names and byte-array approach follow the lessons. Key files use raw
encoded bytes instead of Java object serialization, so **do not reuse key files
created by lesson17/ex1 or ex2** with these helpers.

## Paste into a button handler or method

This example uses AES. Import `File`, `IOException`, `StandardCharsets`,
`GeneralSecurityException` and `Base64` as shown in `Main.java`.

```java
try {
    CryptoAES crypto = new CryptoAES();
    File keyFile = new File("chave.simetrica");

    if (!keyFile.exists()) {
        crypto.geraChave(keyFile); // Only once, before the first encryption.
    }

    byte[] original = "Texto digitado".getBytes(StandardCharsets.UTF_8);
    crypto.geraCifra(original, keyFile);
    String base64 = Base64.getEncoder().encodeToString(crypto.getTextoCifrado());

    // Use Base64 for a JTextArea or text file; ciphertext is not UTF-8 text.
    byte[] encrypted = Base64.getDecoder().decode(base64);
    crypto.geraDecifra(encrypted, keyFile);
    String recovered = new String(crypto.getTextoDecifrado(), StandardCharsets.UTF_8);
    System.out.println(recovered);
} catch (IOException | GeneralSecurityException exception) {
    System.err.println(exception.getMessage());
}
```

If Base64 comes from user input, also catch `IllegalArgumentException` to report
invalid Base64. Call the encryption/decryption method before its corresponding getter.

## Decrypt an existing AES file later

Inside a `try`/`catch` like the one above, with the `Files` and `Path` imports from
`Main.java`:

```java
CryptoAES crypto = new CryptoAES();
File keyFile = new File("chave.simetrica");
byte[] encrypted = Files.readAllBytes(Path.of("texto_cifrado.aes"));
crypto.geraDecifra(encrypted, keyFile); // Do not call geraChave here.
String recovered = new String(crypto.getTextoDecifrado(), StandardCharsets.UTF_8);
System.out.println(recovered);
```

## Remember for the test

- **Dummy** adds the byte position and key, then subtracts them to recover the
  original bytes, following ex1/ex2. It is an educational exercise, not security.
- **AES** uses the same secret key both ways. The helper stores the random IV
  before the ciphertext; save the entire returned byte array. CBC matches the
  lesson but does not detect tampering; this is a course example.
- **RSA** encrypts with the public key and decrypts with the matching private
  key. Keep the private key private. This simpler example handles one block:
  at most **245 UTF-8 bytes** for a 2048-bit key with the lesson's PKCS1 padding.
  Accented characters may occupy multiple bytes. Use AES for longer data, or
  consult `lesson17/ex1/CryptoRSA.java` for the lesson's multiple-block exercise.
- Base64 is a printable representation of bytes, not an encryption algorithm.
- For passwords in an actual application, use password hashing rather than
  any of these reversible encryption examples.
