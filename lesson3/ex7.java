/** 
 * Entrar com um único número inteiro, com 5 dígitos, e
 * imprimir o algarismo correspondente à casa da dezena.
 */

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro com 5 dígitos: ");
        int number = scanner.nextInt();

        int tensDigit = number % 100 / 10;
    
        System.out.println("O algarismo correspondente à casa da dezena é: " + tensDigit);
    }
}