/**
 * Escrever um algoritmo que receba vários números inteiros positivos e 
 * imprima a quantidade de números primos dentre os números que foram digitados. 
 * Parar quando for digitado um número não positivo;
 */

import java.util.Scanner;

public class ex13 {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int primeCount = 0;

        System.out.println("Digite números positivos (número não positivo para parar):");

        while (true) {
            System.out.print("Número: ");
            int number = scanner.nextInt();

            if (number <= 0) {
                break;
            }

            if (isPrime(number)) {
                primeCount++;
            }
        }

        System.out.println("Quantidade de números primos digitados: " + primeCount);

        scanner.close();
    }
}
