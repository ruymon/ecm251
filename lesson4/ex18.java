/**
 * Entrar com dois números e imprimi-los em ordem crescente
 * (suponha números diferentes).
 */

import java.util.Scanner;

public class ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();

        if (first < second) {
            System.out.println("Ordem crescente: " + first + ", " + second);
        } else {
            System.out.println("Ordem crescente: " + second + ", " + first);
        }

        scanner.close();
    }
}