/**
 * Entrar com um número e imprimir o seu logaritmo na base 10
 */

import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número: ");
        double number = scanner.nextDouble();

        double logarithm = Math.log10(number);
        System.out.println("O logaritmo do número é: " + logarithm);

        scanner.close();
    }
}