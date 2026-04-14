/**
 * Crie a classe ContaBancaria com os atributos: número da conta, nome do titular e saldo.
 * Crie métodos para depositar e sacar valores (não permita saldo negativo).
 * Na classe de teste, simule uma operação de depósito e saque.
 */

import java.util.Scanner;

class ContaBancaria {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(String numeroConta, String nomeTitular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public String toString() {
        return "Conta: " + numeroConta + " | Titular: " + nomeTitular + " | Saldo: R$ " + String.format("%.2f", saldo);
    }
}

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();
        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double inicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(numero, titular, inicial);
        System.out.println("Estado inicial: " + conta);

        System.out.print("Valor do depósito: ");
        double deposito = scanner.nextDouble();
        conta.depositar(deposito);
        System.out.println("Após depósito: " + conta);

        System.out.print("Valor do saque: ");
        double saque = scanner.nextDouble();
        if (conta.sacar(saque)) {
            System.out.println("Após saque: " + conta);
        } else {
            System.out.println("Saque não realizado (valor inválido ou saldo insuficiente). Saldo: " + conta.getSaldo());
        }

        scanner.close();
    }
}
