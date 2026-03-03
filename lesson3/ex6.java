/**
 * Crie um algoritmo que calcule o valor de uma dívida,
 * submetida à juros compostos:
 * 
 * ValorFinal = ValorInicial * (1 + J / 100) ^ N
 * 
 * E seja capaz de responder, se você deve para o cartão de
 * crédito R$ 100,00, a uma taxa de juros de 10%, quanto deverá
 * ser pago depois de 8 meses.
 * 
 * Onde:
 * - J representa os juros (em %);
 * - N representa o número de meses;
 */

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor inicial da dívida: ");
        double initialValue = scanner.nextDouble();
        System.out.println("Digite a taxa de juros: ");
        double interestRate = scanner.nextDouble();
        System.out.println("Digite o número de meses: ");
        int months = scanner.nextInt();

        double finalValue = initialValue * Math.pow(1 + interestRate / 100, months);
        
        System.out.println("O valor final da dívida é: " + finalValue);

        scanner.close();
    }
}