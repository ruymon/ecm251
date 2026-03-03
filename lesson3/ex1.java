/**
 * Crie um algoritmo para calcular o número de dias que você
 * está vivo, com base em sua idade, que deverá ser digitada.
 */

import java.util.Scanner;

public class ex1 {
    private static final int DAYS_IN_YEAR = 365; // Não considerando anos bissextos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua idade: ");
        int age = scanner.nextInt();

        int daysAlive = age * DAYS_IN_YEAR;
        
        System.out.println("Você está vivo há " + daysAlive + " dias.");
    }
}