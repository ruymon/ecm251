/**
 * Ler um número inteiro de 4 dígitos e imprimir se é ou não
 * múltiplo de quatro o número formado pelos algarismos que
 * estão nas casas das unidades de milhar e das centenas.
 */

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro de 4 digitos: ");
        int number = scanner.nextInt();
        int absolute = Math.abs(number);

        if (absolute < 1000 || absolute > 9999) {
            System.out.println("Numero invalido. Digite um valor de 4 digitos.");
        } else {
            int formedNumber = absolute / 100;
            if (formedNumber % 4 == 0) {
                System.out.println("O numero " + formedNumber + " e multiplo de 4.");
            } else {
                System.out.println("O numero " + formedNumber + " nao e multiplo de 4.");
            }
        }

        scanner.close();
    }
}