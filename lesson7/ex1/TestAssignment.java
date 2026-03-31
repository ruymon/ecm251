/**
 * Crie a classe TesteAtribuicao com o método main() que
 * instancia um Professor, uma Disciplina e uma Atribuicao.
 * 
 * Imprima dos dados da Atribuicao.
 */

import java.util.Scanner;

public class TestAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do professor: ");
        String professorName = scanner.nextLine();
        System.out.print("Digite a idade do professor: ");
        int professorAge = scanner.nextInt();
        scanner.nextLine();

        Professor professor = new Professor(professorName, professorAge);

        System.out.print("Digite o nome da disciplina: ");
        String subjectName = scanner.nextLine();
        System.out.print("A disciplina é prática? (true/false): ");
        boolean isPractical = scanner.nextBoolean();
        scanner.nextLine();

        Subject subject = new Subject(subjectName, isPractical);

    
        Assignment assignment = new Assignment(professor, subject);
        System.out.println("Atribuição: " + assignment.getDetails());

        scanner.close();
    }
}