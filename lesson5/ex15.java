/**
 * Faça um algoritmo que peça para o usuário digitar um número e mostre na tela 
 * a sequência de Fibonacci de 1 até este número
 */

import java.util.Scanner;

public class ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int limit = scanner.nextInt();

        int a = 0;
        int b = 1;

        System.out.print("Fibonacci: ");

        while (a <= limit) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();

        scanner.close();
    }
}
