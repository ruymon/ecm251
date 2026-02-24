/**
 * Crie e teste, em Java, um algoritmo que leia 10 (dez) 
 * caracteres, um a um, e imprima, de uma só vez, a palavra
 * formada pela união deles.
 */

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "";
        System.out.println("Digite 10 caracteres: ");

        for (int i = 0; i < 10; i++) {
            char character = scanner.next().charAt(0);
            word += character;
        }

        System.out.println("A palavra formada pelos caracteres digitados é: " + word);
    }
}