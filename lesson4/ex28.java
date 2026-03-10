/**
 * Ajude uma escola a montar as divisões do laboratório de
 * programação. Para isso, escreva um algoritmo que leia o
 * nome do aluno e diga em qual divisão ele está respeitando a
 * regra abaixo (dica: use o método charAt(posição):
 * - alunos cujo nome começa com as letras de A a K estão na D1;
 * - alunos cujo nome começa com as letras de L a N estão na D2;
 * - alunos cujo nome começa com as letras de O a Z estão na D3.
 */

import java.util.Scanner;

public class ex28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Nome invalido.");
            scanner.close();
            return;
        }

        char firstLetter = Character.toUpperCase(name.charAt(0));
        if (firstLetter < 'A' || firstLetter > 'Z') {
            System.out.println("Nome deve comecar com uma letra de A a Z.");
        } else if (firstLetter <= 'K') {
            System.out.println("Divisao: D1");
        } else if (firstLetter <= 'N') {
            System.out.println("Divisao: D2");
        } else {
            System.out.println("Divisao: D3");
        }

        scanner.close();
    }
}