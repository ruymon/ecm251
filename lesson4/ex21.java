/**
 *  Ler três números e escrever o maior número (suponha
 * números diferentes).
 */

import java.util.Scanner;

public class ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();
        System.out.print("Digite o terceiro numero: ");
        double third = scanner.nextDouble();

        double biggest = Math.max(first, Math.max(second, third));
        System.out.println("Maior numero: " + biggest);

        scanner.close();
    }
}