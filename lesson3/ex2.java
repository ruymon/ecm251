/**
 * Crie um algoritmo para calcular a área de um retângulo, com
 * base nas medidas de sua base e de sua altura.
 */

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a base do retângulo: ");
        double base = scanner.nextDouble();
        System.out.println("Digite a altura do retângulo: ");
        double height = scanner.nextDouble();

        double area = base * height;
        System.out.println("A área do retângulo é: " + area);
    }
}