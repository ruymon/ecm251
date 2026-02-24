/**
 * Crie e teste, em Java, um algoritmo que leia 4 (quatro) números inteiros, 
 * um a um, de um único dígito cada, representando, na ordem, milhar, centena, 
 * dezena e unidade. 
 * 
 * Use o tipo caractere, para garantir que não seja digitado mais de um número por vez. 
 * Após a concatenação desses números, armazene-os em uma variável do tipo String. 
 * Apresente em tela o valor final dessa String.
 *
 */

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o milhar: ");
        char thousand = scanner.next().charAt(0);

        System.out.println("Digite a centena: ");
        char hundred = scanner.next().charAt(0);

        System.out.println("Digite a dezena: ");
        char ten = scanner.next().charAt(0);

        System.out.println("Digite a unidade: ");
        char unit = scanner.next().charAt(0);

        String number = "" + thousand + hundred + ten + unit;

        System.out.println("O número formado pelos dígitos digitados é: " + number);
    }
}