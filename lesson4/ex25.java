/**
 * Construir um algoritmo que leia três números e imprima se
 * eles podem ou não ser lados de um triângulo. Lembrando
 * que, para ser um triângulo, a soma de dois lados quaisquer
 * deve ser sempre maior que o lado que ficou de fora da soma.
 */

import java.util.Scanner;

public class ex25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro lado: ");
        double sideA = scanner.nextDouble();
        System.out.print("Digite o segundo lado: ");
        double sideB = scanner.nextDouble();
        System.out.print("Digite o terceiro lado: ");
        double sideC = scanner.nextDouble();

        boolean validTriangle = sideA > 0 && sideB > 0 && sideC > 0
                && sideA + sideB > sideC
                && sideA + sideC > sideB
                && sideB + sideC > sideA;

        if (validTriangle) {
            System.out.println("Podem formar um triangulo.");
        } else {
            System.out.println("Nao podem formar um triangulo.");
        }

        scanner.close();
    }
}