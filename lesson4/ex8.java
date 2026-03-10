/**
 * Entrar com dois números e imprimir o maior número
 * (suponha números diferentes).
 */

import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();

        if (first > second) {
            System.out.println("Maior numero: " + first);
        } else {
            System.out.println("Maior numero: " + second);
        }

        scanner.close();
    }
}