import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.SecureRandom;

// Lesson 17 exercise: reversible arithmetic, NOT secure encryption.
public class CryptoDummy {
    private byte[] encryptedText;
    private byte[] decryptedText;

    // Generate once. Replacing this file prevents recovering older ciphertext.
    public void geraChave(File keyFile) throws IOException {
        int key = new SecureRandom().nextInt(101);
        Files.write(keyFile.toPath(), new byte[] { (byte) key });
    }

    public void geraCifra(byte[] text, File keyFile) throws IOException {
        int key = readKey(keyFile);
        encryptedText = new byte[text.length];

        for (int i = 0; i < text.length; i++) {
            encryptedText[i] = (byte) (text[i] + i + key);
        }
    }

    public void geraDecifra(byte[] text, File keyFile) throws IOException {
        int key = readKey(keyFile);
        decryptedText = new byte[text.length];

        for (int i = 0; i < text.length; i++) {
            decryptedText[i] = (byte) (text[i] - i - key);
        }
    }

    private int readKey(File keyFile) throws IOException {
        byte[] key = Files.readAllBytes(keyFile.toPath());

        if (key.length != 1 || (key[0] & 0xff) > 100) {
            throw new IOException("The Dummy key must be one byte from 0 to 100.");
        }

        return key[0] & 0xff;
    }

    public byte[] getTextoCifrado() {
        return encryptedText;
    }

    public byte[] getTextoDecifrado() {
        return decryptedText;
    }
}
