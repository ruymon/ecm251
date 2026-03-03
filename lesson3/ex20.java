/**
 *  Criar um programa capaz de calcular o terceiro lado de um
 * triângulo, digitados os outros dois lados e o ângulo entre eles
 * esses dois lados.
 */

import java.util.Scanner;

public class ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro cateto do triângulo: ");
        double firstCathetus = scanner.nextDouble();
        System.out.println("Digite o segundo cateto do triângulo: ");
        double secondCathetus = scanner.nextDouble();
        System.out.println("Digite o ângulo entre os dois catetos: ");
        double angle = scanner.nextDouble();

        double angleInRadians = Math.toRadians(angle);

        // Law of cosines
        double thirdCathetus = Math.sqrt(Math.pow(firstCathetus, 2) + Math.pow(secondCathetus, 2) - 2 * firstCathetus * secondCathetus * Math.cos(angleInRadians));

        System.out.println("O terceiro lado do triângulo é: " + thirdCathetus);
    }
}