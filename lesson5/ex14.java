/**
 * Entrar com vários números e imprimir o maior. O algoritmo para quando se digita -9999
 */

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite números (-9999 para parar):");

        System.out.print("Número: ");
        double largest = scanner.nextDouble();

        if (largest == -9999) {
            System.out.println("Nenhum número foi digitado.");
        } else {
            while (true) {
                System.out.print("Número: ");
                double number = scanner.nextDouble();

                if (number == -9999) {
                    break;
                }

                if (number > largest) {
                    largest = number;
                }
            }

            System.out.println("Maior número: " + largest);
        }

        scanner.close();
    }
}
