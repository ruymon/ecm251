/**
 * Crie um algoritmo que leia um número inteiro e o eleve ao
 * quadrado usando a classe Math, onde a base e o expoente
 * são números reais.
 */

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro: ");
        
        int number = scanner.nextInt();
        double squared = Math.pow(number, 2);

        System.out.println("O quadrado do número é: " + squared);

        scanner.close();
    }
}