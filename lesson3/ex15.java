/**
 * Crie um algoritmo para calcular a área de um círculo, com
 * base no seu raio (Área = PI*raio*raio, onde PI = 3.14159). 
 * Use variáveis reais.
 */

import java.util.Scanner;

public class ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o raio do círculo: ");
        double radius = scanner.nextDouble();

        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("A área do círculo é: " + area);
    }
}