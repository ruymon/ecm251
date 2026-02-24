/**
 * Crie e teste, em Java, um algoritmo que leia, no formato real,
 * o peso e a altura do usuário, e depois apresente a tela:
 * 
 * "Seus dados digitados foram: <peso>kg e <altura>m"
 */

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu peso: ");
        double weight = scanner.nextDouble();
        System.out.println("Digite sua altura: ");
        double height = scanner.nextDouble();

        System.out.println("Seus dados digitados foram: " + weight + "kg e " + height + "m");
    }
}