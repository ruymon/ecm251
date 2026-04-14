/**
 * Crie a classe Animal com os atributos: espécie, nome e idade.
 * Na classe de teste, permita ao usuário criar dois animais e mostre uma comparação de idade
 * entre eles.
 */

import java.util.Scanner;

class Animal {
    private String especie;
    private String nome;
    private int idade;

    public Animal(String especie, String nome, int idade) {
        this.especie = especie;
        this.nome = nome;
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
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
}

public class ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Animal[] animais = new Animal[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("--- Animal " + (i + 1) + " ---");
            System.out.print("Espécie: ");
            String especie = scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Idade (anos): ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            animais[i] = new Animal(especie, nome, idade);
        }

        Animal a1 = animais[0];
        Animal a2 = animais[1];

        System.out.println();
        System.out.println("Comparação de idade:");
        System.out.println(a1.getNome() + " (" + a1.getEspecie() + "): " + a1.getIdade() + " ano(s)");
        System.out.println(a2.getNome() + " (" + a2.getEspecie() + "): " + a2.getIdade() + " ano(s)");

        if (a1.getIdade() > a2.getIdade()) {
            System.out.println(a1.getNome() + " é mais velho que " + a2.getNome() + ".");
        } else if (a2.getIdade() > a1.getIdade()) {
            System.out.println(a2.getNome() + " é mais velho que " + a1.getNome() + ".");
        } else {
            System.out.println("Ambos têm a mesma idade.");
        }

        scanner.close();
    }
}
