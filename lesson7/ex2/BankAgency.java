/**
 * A classe Agencia tem os atributos nome do tipo String,
 * numero e digito do tipo int. 
 * 
 * Crie um construtor que receba os atributos como parâmetros e os métodos de
 * receba os atributos como parâmetros e os métodos de
 * acesso e os modificadores. O numero e o digito da
 * Agencia devem seguir os mesmos padrões do número e
 * do dígito da conta corrente;
*/

public class BankAgency {
    private String name;
    private int agencyNumber;
    private int agencyDigit;

    public BankAgency(String name, int agencyNumber) {
        this.name = name;
        this.agencyNumber = agencyNumber;
        this.agencyDigit = Utils.calculateDigit(agencyNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(int agencyNumber) {
        this.agencyNumber = agencyNumber;
        this.agencyDigit = Utils.calculateDigit(agencyNumber);
    }

    public int getAgencyDigit() {
        return agencyDigit;
    }

}