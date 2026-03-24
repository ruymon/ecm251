/**
 * Crie a classe TesteTurma com o método main. De modo
 * análogo ao exemplo, peça para o usuário entrar com os
 * valores necessários para criar uma turma, instancie um objeto
 * Turma e depois exiba os dados da turma criada. Depois, peça
 * para o usuário uma nova quantidade de alunos, altere o valor
 * do atributo e exiba os dados novamente.
 */

import java.util.Scanner;

public class TestCollegeClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da turma: ");
        String name = scanner.nextLine();

        System.out.print("Digite o curso da turma: ");
        String course = scanner.nextLine();

        System.out.print("Digite a quantidade de alunos da turma: ");
        int studentCount = scanner.nextInt();

        System.out.print("Digite o número da turma: ");
        int classNumber = scanner.nextInt();

        CollegeClass collegeClass = new CollegeClass(name, course, studentCount, classNumber);

        System.out.println("\n--- Turma Criada ---");
        System.out.println("Nome: " + collegeClass.getName());
        System.out.println("Curso: " + collegeClass.getCourse());
        System.out.println("Quantidade de alunos: " + collegeClass.getStudentCount());
        System.out.println("Número da turma: " + collegeClass.getClassNumber());

        System.out.print("\nDigite uma nova quantidade de alunos: ");
        int newStudentCount = scanner.nextInt();
        collegeClass.setStudentCount(newStudentCount);

        System.out.println("\n--- Turma Atualizada ---");
        System.out.println("Nome: " + collegeClass.getName());
        System.out.println("Curso: " + collegeClass.getCourse());
        System.out.println("Quantidade de alunos: " + collegeClass.getStudentCount());
        System.out.println("Número da turma: " + collegeClass.getClassNumber());

        scanner.close();
    }
}
