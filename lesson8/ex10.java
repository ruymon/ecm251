/**
 * Crie a classe Cidade com os atributos: nome da cidade, estado e população.
 * Na classe de teste, leia os dados e exiba uma frase como:
 *
 * "A cidade de Campinas, localizada em SP, possui 1.200.000 habitantes."
 */

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class Cidade {
    private String nome;
    private String estado;
    private long populacao;

    public Cidade(String nome, String estado, long populacao) {
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public String fraseDescritiva() {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        String popFormatada = nf.format(populacao);
        return String.format(
                "A cidade de %s, localizada em %s, possui %s habitantes.",
                nome, estado, popFormatada);
    }
}

public class ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da cidade: ");
        String nome = scanner.nextLine();
        System.out.print("Estado (UF): ");
        String estado = scanner.nextLine();
        System.out.print("População: ");
        long populacao = scanner.nextLong();

        Cidade cidade = new Cidade(nome, estado, populacao);
        System.out.println(cidade.fraseDescritiva());

        scanner.close();
    }
}
