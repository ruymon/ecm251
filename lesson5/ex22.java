/**
 * Criar um algoritmo que leia um número que servirá para controlar os números pares que serão impressos a partir de 2
 * Exemplo: quantos = 4, imprime 2, 4, 6, 8;
 */

import java.util.Scanner;

public class ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos números pares deseja imprimir? ");
        int count = scanner.nextInt();

        int number = 2;
        for (int i = 0; i < count; i++) {
            System.out.print(number + " ");
            number += 2;
        }
        System.out.println();

        scanner.close();
    }
}
