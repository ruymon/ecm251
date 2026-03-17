/**
 * Ler vários números até entrar o número -999. Para cada número, imprimir sua raiz quadrada e seu inverso
 */

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite números (-999 para parar):");

        while (true) {
            System.out.print("Número: ");
            double number = scanner.nextDouble();

            if (number == -999) {
                break;
            }

            if (number >= 0) {
                System.out.println("Raiz quadrada: " + Math.sqrt(number));
            } else {
                System.out.println("Raiz quadrada: não existe para números negativos");
            }

            if (number != 0) {
                System.out.println("Inverso: " + (1.0 / number));
            } else {
                System.out.println("Inverso: não existe para zero");
            }
        }

        scanner.close();
    }
}
