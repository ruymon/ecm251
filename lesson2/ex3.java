/**
 * Crie e teste, em Java, um algoritmo que leia 1 (um) número inteiro, 
 * armazene-o em uma variável do tipo inteiro, e depois apresente em tela:
 * 
 * "O valor do número digitado é: <número digitado>"
 */

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro: ");
        int number = scanner.nextInt();
        System.out.println("O valor do número digitado é: " + number);
    }
}