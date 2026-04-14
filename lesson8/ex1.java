/**
 * Crie a classe Livro com os atributos: título, autor e número de páginas.
 * Implemente construtores, getters e setters.
 *
 * Na classe TesteLivro, peça ao usuário os dados do livro, crie um objeto Livro e mostre suas
 * informações.
 **/

import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;
    private int numeroPaginas;

    public Livro(String titulo, String autor, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Número de páginas: ");
        int paginas = scanner.nextInt();

        Livro livro = new Livro(titulo, autor, paginas);
        System.out.println();
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Páginas: " + livro.getNumeroPaginas());

        scanner.close();
    }
}
