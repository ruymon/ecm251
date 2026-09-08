import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class CryptoAES {
    private byte[] encryptedText;
    private byte[] decryptedText;

    public void geraChave(File keyFile) throws IOException, GeneralSecurityException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
        SecretKey key = generator.generateKey();

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(keyFile))) {
            output.writeObject(key);
        }
    }

    public void geraCifra(byte[] text, File keyFile)
            throws IOException, GeneralSecurityException, ClassNotFoundException {
        SecretKey key;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(keyFile))) {
            key = (SecretKey) input.readObject();
        }

        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] ciphertext = cipher.doFinal(text);

        encryptedText = new byte[iv.length + ciphertext.length];
        System.arraycopy(iv, 0, encryptedText, 0, iv.length);
        System.arraycopy(ciphertext, 0, encryptedText, iv.length, ciphertext.length);
    }

    public void geraDecifra(byte[] text, File keyFile)
            throws IOException, GeneralSecurityException, ClassNotFoundException {
        SecretKey key;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(keyFile))) {
            key = (SecretKey) input.readObject();
        }

        if (text.length < 16) {
            throw new GeneralSecurityException("Encrypted text does not contain an initialization vector.");
        }

        IvParameterSpec iv = new IvParameterSpec(text, 0, 16);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        decryptedText = cipher.doFinal(text, 16, text.length - 16);
    }

    public byte[] getTextoCifrado() {
        return encryptedText;
    }

    public byte[] getTextoDecifrado() {
        return decryptedText;
    }
}
