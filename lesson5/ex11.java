/**
 * Entrar com a idade de várias pessoas e imprimir: 
 * total de pessoas com menos de 21 anos e total de pessoas com mais de 50 anos. 
 * 
 * Parar quando for digitada uma idade fora da faixa 0-120 anos;
 */

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int under21 = 0;
        int over50 = 0;

        while (true) {
            System.out.print("Digite a idade (fora de 0-120 para parar): ");
            int age = scanner.nextInt();

            if (age < 0 || age > 120) {
                break;
            }

            if (age < 21) {
                under21++;
            }
            if (age > 50) {
                over50++;
            }
        }

        System.out.println("Total de pessoas com menos de 21 anos: " + under21);
        System.out.println("Total de pessoas com mais de 50 anos: " + over50);

        scanner.close();
    }
}
