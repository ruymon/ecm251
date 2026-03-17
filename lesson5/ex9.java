/**
 * Ler vários números até entrar o número -999. Para cada número, imprimir seus divisores;
 */

import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite números (-999 para parar):");

        while (true) {
            System.out.print("Número: ");
            int number = scanner.nextInt();

            if (number == -999) {
                break;
            }

            int absNumber = Math.abs(number);
            System.out.print("Divisores de " + number + ": ");

            for (int i = 1; i <= absNumber; i++) {
                if (absNumber % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
