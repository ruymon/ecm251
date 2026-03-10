/**
 * Entrar com um número e informar se ele é divisível por 10,
 * por 5, por 2 ou se não é divisível por nenhum destes.
 */ 

import java.util.Scanner;

public class ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro: ");
        int number = scanner.nextInt();

        if (number % 10 == 0) {
            System.out.println("E divisivel por 10.");
        } else if (number % 5 == 0) {
            System.out.println("E divisivel por 5.");
        } else if (number % 2 == 0) {
            System.out.println("E divisivel por 2.");
        } else {
            System.out.println("Nao e divisivel por 10, 5 ou 2.");
        }

        scanner.close();
    }
}