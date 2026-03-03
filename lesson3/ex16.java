/**
 * Ler dois números inteiros e imprimir dividendo, divisor,
 * quociente e resto.
 */

import java.util.Scanner;

public class ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número inteiro: ");
        int dividend = scanner.nextInt();
        System.out.println("Digite o segundo número inteiro: ");
        int divisor = scanner.nextInt();

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        System.out.println("Dividendo: " + dividend);
        System.out.println("Divisor: " + divisor);
        System.out.println("Quociente: " + quotient);
        System.out.println("Resto: " + remainder);

        scanner.close();
    }
}