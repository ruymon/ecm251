/**
 * Escrever um algoritmo que lê̂ repetidamente o valor do preço de uma mercadoria 
 * e a quantidade de itens comprados dessa mercadoria. 
 * Quando a quantidade lida for igual a zero, o algoritmo deve mostrar o total a ser pago. 
 * O algoritmo não deve computar valores negativos de preço ou de quantidade;
 * neste caso, o algoritmo deve pedir que o usuário digite novamente o valor do preço ou da quantidade digitados indevidamente 
 * (sugestão: usar outro loop faça-enquanto para cada caso).
 * 
 * OBS.: Considerar a quantidade de mercadorias compradas é desconhecida;
 */

import java.util.Scanner;

public class ex23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total = 0;

        while (true) {
            double price;
            do {
                System.out.print("Preço da mercadoria: ");
                price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("Preço inválido! Digite um valor positivo.");
                }
            } while (price < 0);

            int quantity;
            do {
                System.out.print("Quantidade: ");
                quantity = scanner.nextInt();
                if (quantity < 0) {
                    System.out.println("Quantidade inválida! Digite um valor positivo.");
                }
            } while (quantity < 0);

            if (quantity == 0) {
                break;
            }

            total += price * quantity;
        }

        System.out.printf("Total a pagar: R$ %.2f%n", total);

        scanner.close();
    }
}
