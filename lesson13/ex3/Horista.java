public class Horista extends Empregado {
    private double horasTrabalhadas;
    private double valorHora;

    public Horista(String nome, String matricula, double horasTrabalhadas, double valorHora) {
        super(nome, matricula);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }

    public String toString() {
        return "Tipo: Horista\n" + super.toString()
                + "\nHoras trabalhadas: " + String.format("%.2f", horasTrabalhadas)
                + "\nValor por hora: R$ " + String.format("%.2f", valorHora)
                + "\nSalario calculado: R$ " + String.format("%.2f", calcularSalario());
    }
}
