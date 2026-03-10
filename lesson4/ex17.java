/**
 * Entrar com dois números e imprimir o menor número
 * (suponha números diferentes).
 */

import java.util.Scanner;

public class ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();

        if (first < second) {
            System.out.println("Menor numero: " + first);
        } else {
            System.out.println("Menor numero: " + second);
        }

        scanner.close();
    }
}