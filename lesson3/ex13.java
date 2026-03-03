/**
 * Entre com uma data em uma variável do tipo String no
 * formato dd/mm/aa e imprimir dia, mês e ano separados.
 */

import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma data no formato dd/mm/aa: ");
        String date = scanner.nextLine();

        String[] dateParts = date.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        System.out.println("Dia: " + day);
        System.out.println("Mês: " + month);
        System.out.println("Ano: " + year);

        scanner.close();
    }
}