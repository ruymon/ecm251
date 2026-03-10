/**
 * Ler três números e armazenar o maior número na variável de
 * nome maior (suponha números diferentes).
 */

import java.util.Scanner;

public class ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();
        System.out.print("Digite o terceiro numero: ");
        double third = scanner.nextDouble();

        double maior = Math.max(first, Math.max(second, third));
        System.out.println("Variavel maior = " + maior);

        scanner.close();
    }
}