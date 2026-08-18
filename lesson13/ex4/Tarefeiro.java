public class Tarefeiro extends Empregado {
    private int tarefasFeitas;
    private double valorTarefa;

    public Tarefeiro(String nome, String cpf, int idade, String matricula,
                     int tarefasFeitas, double valorTarefa) {
        super(nome, cpf, idade, matricula);
        this.tarefasFeitas = tarefasFeitas;
        this.valorTarefa = valorTarefa;
    }

    public int getTarefasFeitas() {
        return tarefasFeitas;
    }

    public void setTarefasFeitas(int tarefasFeitas) {
        this.tarefasFeitas = tarefasFeitas;
    }

    public double getValorTarefa() {
        return valorTarefa;
    }

    public void setValorTarefa(double valorTarefa) {
        this.valorTarefa = valorTarefa;
    }

    public double calcularSalario() {
        return tarefasFeitas * valorTarefa;
    }

    public String toString() {
        return "Tipo: Tarefeiro\n" + super.toString()
                + "\nTarefas feitas: " + tarefasFeitas
                + "\nValor por tarefa: R$ " + String.format("%.2f", valorTarefa)
                + "\nSalario calculado: R$ " + String.format("%.2f", calcularSalario());
    }
}
