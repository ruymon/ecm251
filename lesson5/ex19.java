/**
 * Criar um algoritmo que leia um número que será o limite superior de um intervalo e o incremento.
 * Imprimir todos os números do intervalo de 0 até esse número, de incremento em incremento.
 * Ex.: limite 20, incremento 5; vai imprimir 0, 5, 10, 15, 20
 */

import java.util.Scanner;

public class ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o limite superior: ");
        double limit = scanner.nextDouble();

        System.out.print("Digite o incremento: ");
        double increment = scanner.nextDouble();

        double number = 0;
        while (number <= limit) {
            System.out.print(number + " ");
            number += increment;
        }
        System.out.println();

        scanner.close();
    }
}
