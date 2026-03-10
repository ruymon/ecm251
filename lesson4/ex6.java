/**
 * Entrar com um número e imprimir uma das mensagens: maior
 * do que 20, igual a 20 ou menor do que 20.
 */

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        double number = scanner.nextDouble();

        if (number > 20) {
            System.out.println("Maior do que 20.");
        } else if (number == 20) {
            System.out.println("Igual a 20.");
        } else {
            System.out.println("Menor do que 20.");
        }

        scanner.close();
    }
}