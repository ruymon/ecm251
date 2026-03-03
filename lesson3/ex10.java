/**
 * Entrar com um número e a base em que se deseja calcular o
 * logaritmo desse número. Após isto, calcular tal logaritmo e
 * imprimir o resultado.
 */

import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número: ");
        double number = scanner.nextDouble();
        System.out.println("Digite a base: ");
        int base = scanner.nextInt();

        double logarithm = Math.log(number) / Math.log(base);
        
        System.out.println("O logaritmo do número é: " + logarithm);
    }
}