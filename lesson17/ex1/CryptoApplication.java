import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class CryptoApplication {
    private static final String INPUT_FILE = "texto_claro.txt";
    private static final String DUMMY_KEY_FILE = "chave.dummy";
    private static final String AES_KEY_FILE = "chave.simetrica";
    private static final String PUBLIC_KEY_FILE = "chave.publica";
    private static final String PRIVATE_KEY_FILE = "chave.privada";

    public void run(String[] args) {
        String fileName = args.length > 0 ? args[0] : INPUT_FILE;

        try {
            byte[] text = Files.readAllBytes(Path.of(fileName));

            System.out.println("Original text:");
            System.out.println(new String(text, StandardCharsets.UTF_8));

            CryptoDummy dummy = new CryptoDummy();
            File dummyKey = new File(DUMMY_KEY_FILE);
            dummy.geraChave(dummyKey);
            dummy.geraCifra(text, dummyKey);
            dummy.geraDecifra(dummy.getTextoCifrado(), dummyKey);
            printResults("Dummy", dummy.getTextoCifrado(), dummy.getTextoDecifrado());

            CryptoAES aes = new CryptoAES();
            File aesKey = new File(AES_KEY_FILE);
            aes.geraChave(aesKey);
            aes.geraCifra(text, aesKey);
            aes.geraDecifra(aes.getTextoCifrado(), aesKey);
            printResults("AES", aes.getTextoCifrado(), aes.getTextoDecifrado());

            CryptoRSA rsa = new CryptoRSA();
            File publicKey = new File(PUBLIC_KEY_FILE);
            File privateKey = new File(PRIVATE_KEY_FILE);
            rsa.geraParDeChaves(publicKey, privateKey);
            rsa.geraCifra(text, publicKey);
            rsa.geraDecifra(rsa.getTextoCifrado(), privateKey);
            printResults("RSA", rsa.getTextoCifrado(), rsa.getTextoDecifrado());
        } catch (IOException ioException) {
            System.err.println("Error accessing file: " + ioException.getMessage());
            System.exit(1);
        } catch (GeneralSecurityException | ClassNotFoundException cryptoException) {
            System.err.println("Error processing encryption: " + cryptoException.getMessage());
            System.exit(1);
        }
    }

    private void printResults(String algorithm, byte[] encryptedText, byte[] decryptedText) {
        System.out.println("\n" + algorithm);
        System.out.println("Encrypted text (Base64):");
        System.out.println(Base64.getEncoder().encodeToString(encryptedText));
        System.out.println("Decrypted text:");
        System.out.println(new String(decryptedText, StandardCharsets.UTF_8));
    }
}
