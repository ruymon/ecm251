import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.SecureRandom;

public class CryptoDummy {
    private static final int KEY_SIZE = 16;
    private static final int ROTATION = 3;

    private byte[] encryptedText;
    private byte[] decryptedText;

    public void geraChave(File keyFile) throws IOException {
        byte[] key = new byte[KEY_SIZE];
        new SecureRandom().nextBytes(key);
        Files.write(keyFile.toPath(), key);
    }

    public void geraCifra(byte[] text, File keyFile) throws IOException {
        byte[] key = readKey(keyFile);
        encryptedText = new byte[text.length];

        for (int i = 0; i < text.length; i++) {
            int value = (text[i] & 0xff) ^ (key[i % key.length] & 0xff) ^ (i & 0xff);
            int rotated = ((value << ROTATION) | (value >>> (8 - ROTATION))) & 0xff;
            encryptedText[text.length - 1 - i] = (byte) rotated;
        }
    }

    public byte[] getTextoCifrado() {
        return encryptedText.clone();
    }

    public void geraDecifra(byte[] text, File keyFile) throws IOException {
        byte[] key = readKey(keyFile);
        decryptedText = new byte[text.length];

        for (int i = 0; i < text.length; i++) {
            int value = text[text.length - 1 - i] & 0xff;
            int rotated = ((value >>> ROTATION) | (value << (8 - ROTATION))) & 0xff;
            decryptedText[i] = (byte) (rotated ^ (key[i % key.length] & 0xff) ^ (i & 0xff));
        }
    }

    public byte[] getTextoDecifrado() {
        return decryptedText.clone();
    }

    private byte[] readKey(File keyFile) throws IOException {
        byte[] key = Files.readAllBytes(keyFile.toPath());

        if (key.length != KEY_SIZE) {
            throw new IOException("The key file must contain " + KEY_SIZE + " bytes.");
        }

        return key;
    }
}
