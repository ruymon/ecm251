/**
 * Crie um algoritmo capaz de ler três Strings quaisquer,
 * digitadas por meio do console, e apresente a soma do
 * comprimento destas Strings.
 */

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a primeira string: ");
        String firstString = scanner.nextLine();
        System.out.println("Digite a segunda string: ");
        String secondString = scanner.nextLine();
        System.out.println("Digite a terceira string: ");
        String thirdString = scanner.nextLine();

        int length = firstString.length() + secondString.length() + thirdString.length();
        System.out.println("A soma do comprimento das strings é: " + length);

        scanner.close();
    }
}