/**
 * Ler vários números e informar quantos números entre 100 e 200 foram digitados. 
 * Quando o valor 0 (zero) for lido o algoritmo deverá cessar sua execução
 */

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        System.out.println("Digite números (0 para parar):");

        while (true) {
            System.out.print("Número: ");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (number >= 100 && number <= 200) {
                count++;
            }
        }

        System.out.println("Quantidade de números entre 100 e 200: " + count);

        scanner.close();
    }
}
