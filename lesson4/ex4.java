/**
 * Ler três números e escrevê-los em ordem crescente (suponha
 * que são números diferentes).
 */

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();
        System.out.print("Digite o terceiro numero: ");
        double third = scanner.nextDouble();

        if (first > second) {
            double temp = first;
            first = second;
            second = temp;
        }
        if (second > third) {
            double temp = second;
            second = third;
            third = temp;
        }
        if (first > second) {
            double temp = first;
            first = second;
            second = temp;
        }

        System.out.println("Ordem crescente: " + first + ", " + second + ", " + third);
        scanner.close();
    }
}