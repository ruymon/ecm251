import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;

public class CryptoDummy {
    private byte[] encryptedText;
    private byte[] decryptedText;

    public void geraChave(File keyFile) throws IOException {
        int key = new SecureRandom().nextInt(101);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(keyFile))) {
            output.writeObject(Integer.valueOf(key));
        }
    }

    public void geraCifra(byte[] text, File keyFile) throws IOException, ClassNotFoundException {
        int key;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(keyFile))) {
            key = (Integer) input.readObject();
        }

        encryptedText = new byte[text.length];

        for (int i = 0; i < text.length; i++) {
            encryptedText[i] = (byte) (text[i] + i + key);
        }
    }

    public void geraDecifra(byte[] text, File keyFile) throws IOException, ClassNotFoundException {
        int key;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(keyFile))) {
            key = (Integer) input.readObject();
        }

        decryptedText = new byte[text.length];

        for (int i = 0; i < text.length; i++) {
            decryptedText[i] = (byte) (text[i] - i - key);
        }
    }

    public byte[] getTextoCifrado() {
        return encryptedText;
    }

    public byte[] getTextoDecifrado() {
        return decryptedText;
    }
}
