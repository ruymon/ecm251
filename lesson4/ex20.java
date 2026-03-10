/**
 * Criar um algoritmo que deixe entrar com dois números e
 * imprimir o quadrado do menor número e a raiz quadrada do
 * maior número, se for possível (suponha números diferentes).
 */

import java.util.Scanner;

public class ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double first = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double second = scanner.nextDouble();

        double smaller = Math.min(first, second);
        double bigger = Math.max(first, second);

        System.out.println("Quadrado do menor: " + Math.pow(smaller, 2));
        if (bigger >= 0) {
            System.out.println("Raiz quadrada do maior: " + Math.sqrt(bigger));
        } else {
            System.out.println("Nao e possivel calcular raiz quadrada real do maior numero.");
        }

        scanner.close();
    }
}