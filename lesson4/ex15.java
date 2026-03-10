/**
 * Entrar com o ano de nascimento de uma pessoa e o ano atual.
Imprimir a idade da pessoa. Não se esqueça de verificar se o
 * ano de nascimento é um ano válido.
 */

import java.util.Scanner;

public class ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ano de nascimento: ");
        int birthYear = scanner.nextInt();
        System.out.print("Digite o ano atual: ");
        int currentYear = scanner.nextInt();

        if (birthYear <= 0 || currentYear <= 0 || birthYear > currentYear) {
            System.out.println("Ano de nascimento invalido.");
        } else {
            int age = currentYear - birthYear;
            System.out.println("Idade: " + age);
        }

        scanner.close();
    }
}