/**
 * Entrar com o nome, sexo e idade de uma pessoa. Se a pessoa
 * for do sexo feminino e tiver menos que 25 anos, imprimir
 * nome e a mensagem: ACEITA. Caso contrário, imprimir nome
 * e a mensagem: NÃO ACEITA. (Considerar f ou F).
 */

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String name = scanner.nextLine();
        System.out.print("Digite o sexo (M/F): ");
        String sexInput = scanner.nextLine();
        System.out.print("Digite a idade: ");
        int age = scanner.nextInt();

        char sex = sexInput.isEmpty() ? ' ' : sexInput.charAt(0);
        boolean accepted = (sex == 'f' || sex == 'F') && age < 25;

        if (accepted) {
            System.out.println(name + " - ACEITA");
        } else {
            System.out.println(name + " - NAO ACEITA");
        }

        scanner.close();
    }
}