/**
 * Criar um algoritmo que calcule e imprime a área de um
 * triângulo.
 */

import java.util.Scanner;

public class ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a base do triângulo: ");
        double base = scanner.nextDouble();
        System.out.println("Digite a altura do triângulo: ");
        double height = scanner.nextDouble();

        double area = (base * height) / 2;
        System.out.println("A área do triângulo é: " + area);

        scanner.close();
    }
}