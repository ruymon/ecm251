/** 
 * A classe ContaCorrente tem os atributos numero e
 * digito, ambos int, o atributo agencia do tipo Agencia e o
 * atributo saldo do tipo double. 
 * 
 * Crie um construtor que receba os atributos como parâmetros e os métodos de
 * acesso e os modificadores. Crie também um método depositar() que receba um parâmetro double com o valor
 * do depósito e aumente o saldo da conta. Crie também um método sacar() que receba um parâmetro double com o
 * valor do saque e diminua o saldo da conta
 * 
 * A conta não pode ficar negativa. Neste caso, deve ser dada
 * uma mensagem que o saque não foi efetuado e o retorno
 * deve ser zero. Caso contrário o retorno deve ser o valor
 * sacado. 
 * 
 * Crie também um método consultarSaldo() que não receba parâmetros e retorne o saldo. 
 * Crie, finalmente, um método imprimirSaldo() que imprima o numero da conta corrente com dígito, o número da agência com dígito e o saldo da conta corrente;
 * 
 * Ainda na classe ContaCorrente, o número da conta deve
 * ter no máximo 4 dígitos e ser positivo. 
 * 
 * O digito da conta deve ser validado a partir do seguinte algoritmo de
 * módulo 11: multiplique o primeiro dígito da conta por 4, o
 * segundo por 6, o terceiro por 8 e o quarto por 2; some
 * tudo e calcule o resto da divisão (módulo) da soma por 11.
 * 
 * Este é o valor do dígito.
 * 
 * Obs.: se o resultado for 10 o dígito é 0;
 **/

public class CheckingAccount {
    private int accountNumber;
    private int accountDigit;
    private BankAgency bankAgency;
    private double balance;

    public CheckingAccount(int accountNumber, BankAgency bankAgency, double balance) {
        if (accountNumber <= 0 || accountNumber > 9999) {
            throw new IllegalArgumentException("O numero da conta deve ter no maximo 4 digitos e ser positivo.");
        }
        this.accountNumber = accountNumber;
        this.accountDigit = Utils.calculateDigit(accountNumber);
        this.bankAgency = bankAgency;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        if (accountNumber <= 0 || accountNumber > 9999) {
            throw new IllegalArgumentException("O numero da conta deve ter no maximo 4 digitos e ser positivo.");
        }
        
        this.accountNumber = accountNumber;
        this.accountDigit = Utils.calculateDigit(accountNumber);
    }

    public int getAccountDigit() {
        return accountDigit;
    }

    public BankAgency getBankAgency() {
        return bankAgency;
    }

    public void setBankAgency(BankAgency bankAgency) {
        this.bankAgency = bankAgency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        this.balance += amount;
    }
    
    public double withdraw(double amount) {
        if (this.balance - amount < 0) {
            System.out.println("Saldo insuficiente");
            return 0;
        }

        this.balance -= amount;
        return amount;
    }

    public void printBalance() {
        System.out.println("--------------------------------");
        System.out.println("Numero da conta: " + this.accountNumber + "-" + this.accountDigit);
        System.out.println("Numero da agencia: " + this.bankAgency.getAgencyNumber() + "-" + this.bankAgency.getAgencyDigit());
        System.out.println("--------------------------------");
        System.out.println("Saldo: " + this.balance);
        System.out.println("--------------------------------");
    }
        
}