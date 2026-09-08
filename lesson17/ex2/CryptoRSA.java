import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import javax.crypto.Cipher;

public class CryptoRSA {
    private byte[] encryptedText;
    private byte[] decryptedText;

    public void geraParDeChaves(File publicFile, File privateFile) throws IOException, GeneralSecurityException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(publicFile))) {
            output.writeObject(keyPair.getPublic());
        }

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(privateFile))) {
            output.writeObject(keyPair.getPrivate());
        }
    }

    public void geraCifra(byte[] text, File keyFile)
            throws IOException, GeneralSecurityException, ClassNotFoundException {
        PublicKey key;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(keyFile))) {
            key = (PublicKey) input.readObject();
        }

        encryptedText = processBlocks(text, key, Cipher.ENCRYPT_MODE);
    }

    public void geraDecifra(byte[] text, File keyFile)
            throws IOException, GeneralSecurityException, ClassNotFoundException {
        PrivateKey key;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(keyFile))) {
            key = (PrivateKey) input.readObject();
        }

        decryptedText = processBlocks(text, key, Cipher.DECRYPT_MODE);
    }

    private byte[] processBlocks(byte[] text, Key key, int mode) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(mode, key);

        int keySize = (((RSAKey) key).getModulus().bitLength() + 7) / 8;
        int blockSize = mode == Cipher.ENCRYPT_MODE ? keySize - 11 : keySize;

        if (mode == Cipher.DECRYPT_MODE && text.length % blockSize != 0) {
            throw new GeneralSecurityException("Encrypted text contains an incomplete RSA block.");
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        for (int offset = 0; offset < text.length; offset += blockSize) {
            int length = Math.min(blockSize, text.length - offset);
            byte[] block = cipher.doFinal(text, offset, length);
            output.write(block, 0, block.length);
        }

        return output.toByteArray();
    }

    public byte[] getTextoCifrado() {
        return encryptedText;
    }

    public byte[] getTextoDecifrado() {
        return decryptedText;
    }
}
