/**
 * Entrar com um número e imprimir uma das mensagens: é
 * múltiplo de 3 ou não é.
 */

import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro: ");
        int number = scanner.nextInt();

        if (number % 3 == 0) {
            System.out.println("E multiplo de 3.");
        } else {
            System.out.println("Nao e multiplo de 3.");
        }

        scanner.close();
    }
}