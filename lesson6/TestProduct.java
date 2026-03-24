/**
 * Crie uma classe TesteProduto com um método main, onde você vai ler valores
 * de um produto, instanciar um produto e exibir o produto criado.
 */

import java.util.Scanner;

public class TestProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String name = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double price = scanner.nextDouble();

        System.out.print("Digite a quantidade do produto: ");
        int count = scanner.nextInt();

        Product product = new Product(name, price, count);

        System.out.println("\n--- Produto Criado ---");
        System.out.println("Nome: " + product.getName());
        System.out.println("Preço: " + product.getPrice());
        System.out.println("Quantidade: " + product.getCount());

        scanner.close();
    }
}
