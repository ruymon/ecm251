/**
 * Ler cinco números e identificar o maior e o menor de todos
 * (NÃO suponha números diferentes).
 */

import java.util.Scanner;

public class ex24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o 1o numero: ");
        double value = scanner.nextDouble();
        double maior = value;
        double menor = value;

        for (int i = 2; i <= 5; i++) {
            System.out.print("Digite o " + i + "o numero: ");
            value = scanner.nextDouble();
            if (value > maior) {
                maior = value;
            }
            if (value < menor) {
                menor = value;
            }
        }

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);

        scanner.close();
    }
}