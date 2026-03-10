/**
 * Construir um algoritmo que leia dois valores numéricos
 * inteiros e efetue a adição deles; caso o resultado seja maior
 * que 10, apresentá-lo.
 */

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor inteiro: ");
        int firstValue = scanner.nextInt();
        System.out.print("Digite o segundo valor inteiro: ");
        int secondValue = scanner.nextInt();

        int sum = firstValue + secondValue;
        if (sum > 10) {
            System.out.println("Resultado: " + sum);
        } else {
            System.out.println("Resultado nao e maior que 10.");
        }

        scanner.close();
    }
}
