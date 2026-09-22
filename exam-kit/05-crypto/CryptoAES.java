import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Matches the lesson's AES/CBC example; it does not detect tampering.
public class CryptoAES {
    private byte[] encryptedText;
    private byte[] decryptedText;

    // Generate once and keep this file to decrypt later.
    public void geraChave(File keyFile) throws IOException, GeneralSecurityException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
        SecretKey key = generator.generateKey();
        Files.write(keyFile.toPath(), key.getEncoded());
    }

    public void geraCifra(byte[] text, File keyFile)
            throws IOException, GeneralSecurityException {
        SecretKey key = readKey(keyFile);
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] ciphertext = cipher.doFinal(text);

        // Store the IV before the ciphertext: [16-byte IV][encrypted bytes].
        encryptedText = new byte[iv.length + ciphertext.length];
        System.arraycopy(iv, 0, encryptedText, 0, iv.length);
        System.arraycopy(ciphertext, 0, encryptedText, iv.length, ciphertext.length);
    }

    public void geraDecifra(byte[] text, File keyFile)
            throws IOException, GeneralSecurityException {
        if (text.length < 32 || (text.length - 16) % 16 != 0) {
            throw new GeneralSecurityException("Invalid AES ciphertext length.");
        }

        SecretKey key = readKey(keyFile);
        IvParameterSpec iv = new IvParameterSpec(text, 0, 16);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        decryptedText = cipher.doFinal(text, 16, text.length - 16);
    }

    private SecretKey readKey(File keyFile) throws IOException {
        byte[] key = Files.readAllBytes(keyFile.toPath());

        if (key.length != 16) {
            throw new IOException("The AES-128 key must contain 16 bytes.");
        }

        return new SecretKeySpec(key, "AES");
    }

    public byte[] getTextoCifrado() {
        return encryptedText;
    }

    public byte[] getTextoDecifrado() {
        return decryptedText;
    }
}
