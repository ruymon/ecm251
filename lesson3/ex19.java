/**
 * Criar um algoritmo que calcule e imprime a área de um
 * losango.
 */

import java.util.Scanner;

public class ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a diagonal maior do losango: ");
        double majorDiagonal = scanner.nextDouble();
        System.out.println("Digite a diagonal menor do losango: ");
        double minorDiagonal = scanner.nextDouble();

        double area = (majorDiagonal * minorDiagonal) / 2;
        System.out.println("A área do losango é: " + area);
    }
}