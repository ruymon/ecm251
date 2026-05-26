public class Comissionado extends Empregado {
    private double salarioBase;
    private double vendas;
    private double percentual;

    public Comissionado(String nome, String cpf, int idade, String matricula,
                        double salarioBase, double vendas, double percentual) {
        super(nome, cpf, idade, matricula);
        this.salarioBase = salarioBase;
        this.vendas = vendas;
        this.percentual = percentual;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public double calcularSalario() {
        return salarioBase + vendas * (percentual / 100.0);
    }

    public String toString() {
        return "Tipo: Comissionado\n" + super.toString()
                + "\nSalario base: R$ " + String.format("%.2f", salarioBase)
                + "\nVendas: R$ " + String.format("%.2f", vendas)
                + "\nPercentual: " + String.format("%.2f", percentual) + "%"
                + "\nSalario calculado: R$ " + String.format("%.2f", calcularSalario());
    }
}
