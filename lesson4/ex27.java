/**
 * Entrar com um verbo no infinitivo e imprimir se o verbo é da
 * 1ª conjugação (terminados em ar), da 2ª conjugação
 * (terminados em er), da 3ª conjugação (terminados em ir), se
 * não está no infinitivo (não termina em r) ou se provavelmente
 * nem é verbo no infinitivo (termina em or ou em ur).
 */

import java.util.Scanner;

public class ex27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um verbo: ");
        String verb = scanner.nextLine().trim().toLowerCase();

        if (verb.endsWith("or") || verb.endsWith("ur")) {
            System.out.println("Provavelmente nao e verbo no infinitivo.");
        } else if (!verb.endsWith("r")) {
            System.out.println("Nao esta no infinitivo.");
        } else if (verb.endsWith("ar")) {
            System.out.println("Verbo da 1a conjugacao.");
        } else if (verb.endsWith("er")) {
            System.out.println("Verbo da 2a conjugacao.");
        } else if (verb.endsWith("ir")) {
            System.out.println("Verbo da 3a conjugacao.");
        } else {
            System.out.println("Verbo no infinitivo, conjugacao nao identificada.");
        }

        scanner.close();
    }
}