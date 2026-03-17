/**
 * Criar um algoritmo que leia um número que será o limite superior de um intervalo 
 * e imprimir todos os números ímpares menores do que esse número. 
 * 
 * Exemplo: limite 15, imprime 1, 3, 5, 7, 9, 11, 13
 */

import java.util.Scanner;

public class ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o limite superior: ");
        int limit = scanner.nextInt();

        int number = 1;
        while (number < limit) {
            System.out.print(number + " ");
            number += 2;
        }
        System.out.println();

        scanner.close();
    }
}
