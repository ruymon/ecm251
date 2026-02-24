/**
 * Crie e teste, em Java, um algoritmo que leia 3 (três) números, separadamente, 
 * que representem uma data, respectivamente, dia, mês e ano, e depois apresente a tela:
 * 
 * "A data digitada foi <DD>/<MM>/<AAAA>”"
 */

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o dia: ");
        int day = scanner.nextInt();
        System.out.println("Digite o mês: ");
        int month = scanner.nextInt();
        System.out.println("Digite o ano: ");
        int year = scanner.nextInt();
        
        System.out.println("A data digitada foi " + day + "/" + month + "/" + year);
    }
}