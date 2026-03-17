/**
 * Entrar com o nome, idade e sexo de 20 pessoas.
 * Imprimir o nome sempre que a pessoa for do sexo masculino e tiver mais de 21 anos;
 */

import java.util.Scanner;

public class ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 20; i++) {
            System.out.println("--- Pessoa " + i + " ---");

            System.out.print("Nome: ");
            String name = scanner.nextLine();

            System.out.print("Idade: ");
            int age = scanner.nextInt();

            System.out.print("Sexo (M/F): ");
            String sex = scanner.next();

            scanner.nextLine();

            if (sex.equalsIgnoreCase("M") && age > 21) {
                System.out.println(">> " + name);
            }
        }

        scanner.close();
    }
}
