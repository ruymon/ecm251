/**
 *  Construir um algoritmo que leia três números que
 * representam os lados de um triângulo e que imprima se o
 * triângulo é equilátero (três lados iguais), isósceles (dois lados
 * iguais) ou escaleno (três lados diferentes). Antes, não se
 * esqueça de testar se os três lados realmente formam um
 * triângulo. Informe o usuário caso não formem.
 */

import java.util.Scanner;

public class ex26 {
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

        if (!validTriangle) {
            System.out.println("Os valores informados nao formam um triangulo.");
        } else if (sideA == sideB && sideB == sideC) {
            System.out.println("Triangulo equilatero.");
        } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
            System.out.println("Triangulo isosceles.");
        } else {
            System.out.println("Triangulo escaleno.");
        }

        scanner.close();
    }
}