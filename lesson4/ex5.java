/**
 * Construir um algoritmo que indique se o número digitado está
 * compreendido entre 20 e 90 ou não.
 */

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        double number = scanner.nextDouble();

        if (number >= 20 && number <= 90) {
            System.out.println("O numero esta entre 20 e 90.");
        } else {
            System.out.println("O numero nao esta entre 20 e 90.");
        }

        scanner.close();
    }
}