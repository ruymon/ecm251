/**
 * Entre com uma data em uma variável do tipo inteiro no
 * formato ddmmaa e imprimir dia, mês e ano separados.
 */

import java.util.Scanner;

public class ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma data no formato ddmmaa: ");
        int date = scanner.nextInt();

        int day = date / 10000;
        int month = date % 10000 / 100;
        int year = date % 100;

        System.out.println("Dia: " + day);
        System.out.println("Mês: " + month);
        System.out.println("Ano: " + year);

        scanner.close();
    }
}