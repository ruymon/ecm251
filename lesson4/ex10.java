/**
 * Entrar com um número e informar se ele é ou não divisível
 * por 5.
 */

import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro: ");
        int number = scanner.nextInt();

        if (number % 5 == 0) {
            System.out.println("E divisivel por 5.");
        } else {
            System.out.println("Nao e divisivel por 5.");
        }

        scanner.close();
    }
}