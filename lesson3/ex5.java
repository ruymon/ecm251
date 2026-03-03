/**
 * Crie um algoritmo capaz de ler dez palavras quaisquer,
 * gravadas em um arquivo texto, e as apresente no console em
 * ordem inversa do arquivo.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex5 {
    private static final int WORDS_COUNT = 10;

    private static String[] parseFile(String directory) throws FileNotFoundException {
        String[] words = new String[WORDS_COUNT];
        Scanner fileScanner = new Scanner(new File(directory));

        int count = 0;
        while (fileScanner.hasNext() && count < WORDS_COUNT) {
            words[count] = fileScanner.next();
            count++;
        }

        fileScanner.close();
        return words;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o diretório do arquivo: ");
        String directory = scanner.nextLine();

        String[] words = parseFile(directory);

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.println(words[i]);
        }

        scanner.close();
    }
}
