/**
 * A classe Cliente possui os atributos nome e cpf, ambos
 * do tipo String, e um atributo conta do tipo ContaCorrente.
 * Crie um construtor que receba os atributos como
 * parâmetros e os métodos de acesso e os modificadores.
 */

public class Client {
    private String name;
    private String taxId;
    private CheckingAccount checkingAccount;

    public Client(String name, String taxId, CheckingAccount checkingAccount) {
        this.name = name;
        this.taxId = taxId;
        this.checkingAccount = checkingAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }
}