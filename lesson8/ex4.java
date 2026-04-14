/**
 * Crie a classe Produto com os atributos: nome, código e preço.
 * Crie uma classe de teste que leia os dados de um produto e mostre uma “etiqueta” do produto
 * com seus dados.
 */

import java.util.Scanner;

class Produto {
    private String nome;
    private String codigo;
    private double preco;

    public Produto(String nome, String codigo, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String etiqueta() {
        return "========== ETIQUETA ==========\n"
                + "Produto: " + nome + "\n"
                + "Código:  " + codigo + "\n"
                + "Preço:   R$ " + String.format("%.2f", preco) + "\n"
                + "==============================";
    }
}

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Preço (R$): ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(nome, codigo, preco);
        System.out.println();
        System.out.println(produto.etiqueta());

        scanner.close();
    }
}
