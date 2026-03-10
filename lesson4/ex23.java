/**
 * Ler três números e armazená-los em três variáveis com os
 * seguintes nomes, de acordo com seus valores relativos: maior,
 * intermediário e menor (suponha números diferentes).
 */

import java.util.Scanner;

public class ex23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();
        System.out.print("Digite o terceiro numero: ");
        double third = scanner.nextDouble();

        if (first > second) {
            double temp = first;
            first = second;
            second = temp;
        }
        if (second > third) {
            double temp = second;
            second = third;
            third = temp;
        }
        if (first > second) {
            double temp = first;
            first = second;
            second = temp;
        }

        double menor = first;
        double intermediario = second;
        double maior = third;

        System.out.println("maior = " + maior);
        System.out.println("intermediario = " + intermediario);
        System.out.println("menor = " + menor);

        scanner.close();
    }
}