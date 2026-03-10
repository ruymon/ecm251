/**
 * Entrar com um número e imprimir a raiz quadrada do número
 * caso ele seja positivo e o quadrado do número caso seja
 * negativo.
*/

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        double number = scanner.nextDouble();

        if (number >= 0) {
            System.out.println("Raiz quadrada: " + Math.sqrt(number));
        } else {
            System.out.println("Quadrado: " + Math.pow(number, 2));
        }

        scanner.close();
    }
}