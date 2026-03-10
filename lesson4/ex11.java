/**
 * Entrar com um número e informar se ele é divisível por 3 e
 * por 7.
 */

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro: ");
        int number = scanner.nextInt();

        if (number % 3 == 0 && number % 7 == 0) {
            System.out.println("E divisivel por 3 e por 7.");
        } else {
            System.out.println("Nao e divisivel por 3 e por 7 ao mesmo tempo.");
        }

        scanner.close();
    }
}