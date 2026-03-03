/**
 * Entrar com um ângulo em graus e imprimir seu seno, cosseno,
 * tangente, secante, cossecante e cotangente.
 */

import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um ângulo em graus: ");
        double angle = scanner.nextDouble();
        double angleInRadians = Math.toRadians(angle);

        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);
        double secant = 1 / cosine;
        double cosecant = 1 / sine;
        double cotangent = 1 / tangent;

        System.out.println("O seno do ângulo é: " + sine);
        System.out.println("O cosseno do ângulo é: " + cosine);
        System.out.println("A tangente do ângulo é: " + tangent);
        System.out.println("A secante do ângulo é: " + secant);
        System.out.println("A cossecante do ângulo é: " + cosecant);
        System.out.println("A cotangente do ângulo é: " + cotangent);
    }
}