import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

// Small-message version of the lesson's RSA/ECB/PKCS1Padding example.
public class CryptoRSA {
    private byte[] encryptedText;
    private byte[] decryptedText;

    public void geraParDeChaves(File publicFile, File privateFile)
            throws IOException, GeneralSecurityException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();

        Files.write(publicFile.toPath(), keyPair.getPublic().getEncoded());
        Files.write(privateFile.toPath(), keyPair.getPrivate().getEncoded());
    }

    public void geraCifra(byte[] text, File keyFile)
            throws IOException, GeneralSecurityException {
        byte[] keyBytes = Files.readAllBytes(keyFile.toPath());
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PublicKey key = factory.generatePublic(new X509EncodedKeySpec(keyBytes));
        int keySize = (((RSAKey) key).getModulus().bitLength() + 7) / 8;
        int maximumBytes = keySize - 11;

        if (text.length > maximumBytes) {
            throw new GeneralSecurityException("RSA accepts at most " + maximumBytes
                    + " bytes here. Use AES for longer text or files.");
        }

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        encryptedText = cipher.doFinal(text);
    }

    public void geraDecifra(byte[] text, File keyFile)
            throws IOException, GeneralSecurityException {
        byte[] keyBytes = Files.readAllBytes(keyFile.toPath());
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PrivateKey key = factory.generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
        int keySize = (((RSAKey) key).getModulus().bitLength() + 7) / 8;

        if (text.length != keySize) {
            throw new GeneralSecurityException("The ciphertext must contain one RSA block.");
        }

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        decryptedText = cipher.doFinal(text);
    }

    public byte[] getTextoCifrado() {
        return encryptedText;
    }

    public byte[] getTextoDecifrado() {
        return decryptedText;
    }
}
