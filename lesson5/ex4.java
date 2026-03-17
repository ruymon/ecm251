/**
 * Entrar com nomes enquanto forem diferentes de FIM e imprimir cada nome digitado
 */

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um nome (FIM para parar): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("FIM")) {
                break;
            }

            System.out.println("Nome digitado: " + name);
        }

        scanner.close();
    }
}
