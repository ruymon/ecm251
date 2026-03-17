/**
 * Entrar com vários números positivos e imprimir a média dos números digitados
 */

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        int count = 0;

        System.out.println("Digite números positivos (número negativo ou zero para parar):");

        while (true) {
            System.out.print("Número: ");
            double number = scanner.nextDouble();

            if (number <= 0) {
                break;
            }

            sum += number;
            count++;
        }

        if (count > 0) {
            System.out.println("Média: " + (sum / count));
        } else {
            System.out.println("Nenhum número positivo foi digitado.");
        }

        scanner.close();
    }
}
