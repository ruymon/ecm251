/**
 * Entrar com um número e imprimir o número, seu quadrado e
 * sua raiz quadrada.
 */

import java.util.Scanner;

public class ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número: ");
        double number = scanner.nextDouble();

        double square = Math.pow(number, 2);
        double squareRoot = Math.sqrt(number);

        System.out.println("Número: " + number);
        System.out.println("Quadrado: " + square);
        System.out.println("Raiz quadrada: " + squareRoot);
    }
}