/**
 * Construir um algoritmo que leia dois números e efetue a
 * adição. Caso o valor somado seja menor ou igual a 20, este
 * deverá ser apresentado subtraindo-se 5;
 */

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double firstNumber = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double secondNumber = scanner.nextDouble();

        double sum = firstNumber + secondNumber;
        if (sum <= 20) {
            System.out.println("Resultado: " + (sum - 5));
        } else {
            System.out.println("Resultado: " + sum);
        }

        scanner.close();
    }
}