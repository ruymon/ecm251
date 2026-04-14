/**
 * Crie a classe Funcionario com os atributos: nome, cargo e salário.
 * Adicione um método que retorne o salário anual.
 * Na classe de teste, leia os dados, calcule e exiba o salário anual.
 */

import java.util.Scanner;

class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double salarioAnual() {
        return salario * 12;
    }
}

public class ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Salário mensal (R$): ");
        double salario = scanner.nextDouble();

        Funcionario f = new Funcionario(nome, cargo, salario);
        System.out.printf("Salário anual de %s: R$ %.2f%n", f.getNome(), f.salarioAnual());

        scanner.close();
    }
}
