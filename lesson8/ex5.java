/**
 * Crie a classe Filme com os atributos: nome, diretor e ano de lançamento.
 * Implemente os métodos e teste a criação de um filme com dados do usuário.
 */

import java.util.Scanner;

class Filme {
    private String nome;
    private String diretor;
    private int anoLancamento;
    
    public Filme(String nome, String diretor, int anoLancamento) {
        this.nome = nome;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String toString() {
        return "Filme: " + nome + "\nDiretor: " + diretor + "\nAno de lançamento: " + anoLancamento;
    }
}

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do filme: ");
        String nome = scanner.nextLine();
        System.out.print("Diretor: ");
        String diretor = scanner.nextLine();
        System.out.print("Ano de lançamento: ");
        int ano = scanner.nextInt();

        Filme filme = new Filme(nome, diretor, ano);
        System.out.println();
        System.out.println(filme);

        scanner.close();
    }
}
