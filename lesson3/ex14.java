/**
 * Escrever um algoritmo que leia três números reais a, b e c,
 * calcule e escreva o resultado da expressão:
 * 
 * x = 2 * ( ( a – c ) / 8 ) – b * 5.
 */

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor de a: ");
        double a = scanner.nextDouble();
        System.out.println("Digite o valor de b: ");
        double b = scanner.nextDouble();
        System.out.println("Digite o valor de c: ");
        double c = scanner.nextDouble();

        double x = 2 * ((a - c) / 8) - b * 5;
        System.out.println("O valor de x é: " + x);
    }
}