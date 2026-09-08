import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Base64;

public class CryptoApplication {
    private static final String FILE_NAME = "texto_claro.txt";
    private static final String KEY_FILE_NAME = "chave.dummy";

    public void run(String[] args) {
        Path inputFile = Path.of(args.length > 0 ? args[0] : FILE_NAME);
        File keyFile = new File(KEY_FILE_NAME);
        CryptoDummy crypto = new CryptoDummy();

        try {
            byte[] original = Files.readAllBytes(inputFile);
            crypto.geraChave(keyFile);
            crypto.geraCifra(original, keyFile);
            byte[] encrypted = crypto.getTextoCifrado();
            crypto.geraDecifra(encrypted, keyFile);
            byte[] decrypted = crypto.getTextoDecifrado();

            System.out.println("Original text:");
            System.out.println(new String(original, StandardCharsets.UTF_8));
            System.out.println("Encrypted text (Base64):");
            System.out.println(Base64.getEncoder().encodeToString(encrypted));
            System.out.println("Decrypted text:");
            System.out.println(new String(decrypted, StandardCharsets.UTF_8));
            System.out.println("Original and decrypted bytes match: " + Arrays.equals(original, decrypted));
        } catch (IOException ioException) {
            System.err.println("Error processing file: " + ioException.getMessage());
            System.exit(1);
        }
    }
}
