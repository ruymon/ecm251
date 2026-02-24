/**
 * Crie e teste, em Java, um algoritmo que leia 3 (três) palavras, 
 * uma a uma, separadamente, e as apresente e tela, na mesma
 * ordem em que foram digitadas, numa única linha, separadas
 * por espaços.
 */

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a primeira palavra: ");
        String firstWord = scanner.nextLine();
        System.out.println("Digite a segunda palavra: ");
        String secondWord = scanner.nextLine();
        System.out.println("Digite a terceira palavra: ");
        String thirdWord = scanner.nextLine();

        System.out.println(firstWord + " " + secondWord + " " + thirdWord);
    }
}