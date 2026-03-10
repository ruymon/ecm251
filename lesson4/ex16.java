/**
 * Crie um algoritmo que leia dois números e imprimir uma
 * mensagem dizendo se são iguais ou diferentes.
 */

import java.util.Scanner;

public class ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();

        if (first == second) {
            System.out.println("Os numeros sao iguais.");
        } else {
            System.out.println("Os numeros sao diferentes.");
        }

        scanner.close();
    }
}