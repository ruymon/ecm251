/**
 * Crie um algoritmo que calcule o fatorial de um número.
 * Exemplo: 0! = 1; 1! = 1; 2! = 1*2 = 2; 3! = 1*2*3 = 6; 4! = 1*2*3*4 = 24; 5! = 1*2*3*4*5 = 120;
 */

import java.util.Scanner;

public class ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Fatorial não é definido para números negativos.");
        } else {
            long factorial = 1;

            for (int i = 2; i <= number; i++) {
                factorial *= i;
            }

            System.out.println(number + "! = " + factorial);
        }

        scanner.close();
    }
}
