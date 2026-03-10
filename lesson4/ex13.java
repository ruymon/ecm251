/**
 * Ler um número inteiro de 3 dígitos e imprimir se o algarismo
 * da casa das dezenas é par ou ímpar.
 */

import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro de 3 digitos: ");
        int number = scanner.nextInt();
        int absolute = Math.abs(number);

        if (absolute < 100 || absolute > 999) {
            System.out.println("Numero invalido. Digite um valor de 3 digitos.");
        } else {
            int tensDigit = (absolute / 10) % 10;
            if (tensDigit % 2 == 0) {
                System.out.println("O algarismo das dezenas (" + tensDigit + ") e par.");
            } else {
                System.out.println("O algarismo das dezenas (" + tensDigit + ") e impar.");
            }
        }

        scanner.close();
    }
}