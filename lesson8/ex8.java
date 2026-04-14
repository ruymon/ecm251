/**
 * Crie a classe Pessoa com os atributos: nome, idade e altura.
 * Na classe de teste, leia os dados e apresente uma mensagem de boas-vindas com essas
 * informações.
 */

import java.util.Scanner;

class Pessoa {
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String mensagemBoasVindas() {
        return String.format(
                "Bem-vindo(a), %s! Você tem %d anos e %.2f m de altura. É um prazer conhecê-lo(a).",
                nome, idade, altura);
    }
}

public class ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Altura (m): ");
        double altura = scanner.nextDouble();

        Pessoa pessoa = new Pessoa(nome, idade, altura);
        System.out.println(pessoa.mensagemBoasVindas());

        scanner.close();
    }
}
