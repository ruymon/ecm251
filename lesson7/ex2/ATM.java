/**
 * Para testar, faça uma classe CaixaEletronico, que irá conter o método main(). 
 * Nele, instancie um cliente com os seguintes dados:
 * 
 * Nome: Ademar Apior
 * CPF: 123231518-12
 * Conta Corrente: 1234 Dígito: 4
 * Agencia: 7890 Dígito: 5
 * Saldo Inicial: 150.00
 * 
 * Operações de teste:
 * - sacar 140.0 (sucesso);
 * - consultar saldo (resultado é 10.0);
 * - sacar 200.0 (falha);
 * - consultar saldo (resultado é 10.0);
 * - depositar 25.45 (sucesso);
 * - imprimir saldo (além dos dados de cliente, conta e agencia, o saldo deve ser 35.45).
 */

public class ATM {
    public static void main(String[] args) {
        BankAgency bankAgency = new BankAgency("Banco Demonstrativo", 7890);
        CheckingAccount checkingAccount = new CheckingAccount(1234, bankAgency, 150.00);
        Client client = new Client("Ademar Apior", "123231518-12", checkingAccount);

        System.out.println("Cliente: " + client.getName());
        System.out.println("CPF: " + client.getTaxId());
        System.out.println("Conta Corrente: " + checkingAccount.getAccountNumber() + "-" + checkingAccount.getAccountDigit());
        System.out.println("Agencia: " + bankAgency.getAgencyNumber() + "-" + bankAgency.getAgencyDigit());
        System.out.println("Saldo: " + checkingAccount.getBalance());

        checkingAccount.withdraw(140);
        checkingAccount.printBalance();

        checkingAccount.withdraw(200);
        checkingAccount.printBalance();

        checkingAccount.deposit(25.45);
        checkingAccount.printBalance();
    }
}
