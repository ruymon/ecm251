import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class CryptoApplication {
    private static final String INPUT_FILE = "texto_claro.txt";
    private static final String ENCRYPTED_FILE = "texto_cifrada.txt";
    private static final String DECRYPTED_FILE = "texto_decifrado.txt";
    private static final String DUMMY_KEY_FILE = "chave.dummy";
    private static final String AES_KEY_FILE = "chave.simetrica";
    private static final String PUBLIC_KEY_FILE = "chave.publica";
    private static final String PRIVATE_KEY_FILE = "chave.privada";

    public void run(String[] args) {
        String fileName = args.length > 0 ? args[0] : INPUT_FILE;

        try {
            byte[] text = Files.readAllBytes(Path.of(fileName));
            StringBuilder encryptedResults = new StringBuilder();
            StringBuilder decryptedResults = new StringBuilder();

            CryptoDummy dummy = new CryptoDummy();
            File dummyKey = new File(DUMMY_KEY_FILE);
            dummy.geraChave(dummyKey);
            dummy.geraCifra(text, dummyKey);
            dummy.geraDecifra(dummy.getTextoCifrado(), dummyKey);
            appendResults("Dummy", dummy.getTextoCifrado(), dummy.getTextoDecifrado(),
                    encryptedResults, decryptedResults);

            CryptoAES aes = new CryptoAES();
            File aesKey = new File(AES_KEY_FILE);
            aes.geraChave(aesKey);
            aes.geraCifra(text, aesKey);
            aes.geraDecifra(aes.getTextoCifrado(), aesKey);
            appendResults("AES", aes.getTextoCifrado(), aes.getTextoDecifrado(),
                    encryptedResults, decryptedResults);

            CryptoRSA rsa = new CryptoRSA();
            File publicKey = new File(PUBLIC_KEY_FILE);
            File privateKey = new File(PRIVATE_KEY_FILE);
            rsa.geraParDeChaves(publicKey, privateKey);
            rsa.geraCifra(text, publicKey);
            rsa.geraDecifra(rsa.getTextoCifrado(), privateKey);
            appendResults("RSA", rsa.getTextoCifrado(), rsa.getTextoDecifrado(),
                    encryptedResults, decryptedResults);

            Files.writeString(Path.of(ENCRYPTED_FILE), encryptedResults, StandardCharsets.UTF_8);
            Files.writeString(Path.of(DECRYPTED_FILE), decryptedResults, StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            System.err.println("Error accessing file: " + ioException.getMessage());
            System.exit(1);
        } catch (GeneralSecurityException | ClassNotFoundException cryptoException) {
            System.err.println("Error processing encryption: " + cryptoException.getMessage());
            System.exit(1);
        }
    }

    private void appendResults(String algorithm, byte[] encryptedText, byte[] decryptedText,
            StringBuilder encryptedResults, StringBuilder decryptedResults) {
        encryptedResults.append(algorithm).append(" (Base64)\n");
        encryptedResults.append(Base64.getEncoder().encodeToString(encryptedText)).append("\n\n");

        decryptedResults.append(algorithm).append("\n");
        decryptedResults.append(new String(decryptedText, StandardCharsets.UTF_8)).append("\n\n");
    }
}
