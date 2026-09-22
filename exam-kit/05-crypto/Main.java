import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String message = args.length > 0 ? args[0] : "Olá, João! Criptografia na aula de Java.";
        byte[] original = message.getBytes(StandardCharsets.UTF_8);

        try {
            CryptoDummy dummy = new CryptoDummy();
            File dummyKey = new File("chave.dummy");

            if (!dummyKey.exists()) {
                dummy.geraChave(dummyKey);
            }

            dummy.geraCifra(original, dummyKey);
            dummy.geraDecifra(dummy.getTextoCifrado(), dummyKey);
            printResults("Dummy (exercise only)", dummy.getTextoCifrado(), dummy.getTextoDecifrado());

            CryptoAES aes = new CryptoAES();
            File aesKey = new File("chave.simetrica");

            if (!aesKey.exists()) {
                aes.geraChave(aesKey);
            }

            aes.geraCifra(original, aesKey);
            Files.write(Path.of("texto_cifrado.aes"), aes.getTextoCifrado());

            // A new object can decrypt saved bytes if it uses the SAME key file.
            CryptoAES reader = new CryptoAES();
            reader.geraDecifra(Files.readAllBytes(Path.of("texto_cifrado.aes")), aesKey);
            printResults("AES", aes.getTextoCifrado(), reader.getTextoDecifrado());

            CryptoRSA rsa = new CryptoRSA();
            File publicKey = new File("chave.publica");
            File privateKey = new File("chave.privada");

            if (!publicKey.exists() && !privateKey.exists()) {
                rsa.geraParDeChaves(publicKey, privateKey);
            } else if (!publicKey.exists() || !privateKey.exists()) {
                throw new IOException("One RSA key is missing. Restore the matching key pair.");
            }

            rsa.geraCifra(original, publicKey);
            rsa.geraDecifra(rsa.getTextoCifrado(), privateKey);
            printResults("RSA", rsa.getTextoCifrado(), rsa.getTextoDecifrado());
        } catch (IOException | GeneralSecurityException exception) {
            System.err.println("Error: " + exception.getMessage());
            System.exit(1);
        }
    }

    private static void printResults(String algorithm, byte[] encrypted, byte[] decrypted) {
        System.out.println("\n" + algorithm);
        System.out.println("Encrypted (Base64): " + Base64.getEncoder().encodeToString(encrypted));
        System.out.println("Decrypted: " + new String(decrypted, StandardCharsets.UTF_8));
    }
}
