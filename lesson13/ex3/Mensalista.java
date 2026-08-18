public class Mensalista extends Empregado {
    private double salarioMensal;

    public Mensalista(String nome, String matricula, double salarioMensal) {
        super(nome, matricula);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public double calcularSalario() {
        return salarioMensal;
    }

    public String toString() {
        return "Tipo: Mensalista\n" + super.toString()
                + "\nSalario mensal: R$ " + String.format("%.2f", salarioMensal)
                + "\nSalario calculado: R$ " + String.format("%.2f", calcularSalario());
    }
}
