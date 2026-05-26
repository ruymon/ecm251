public abstract class Empregado extends PessoaFisica {
    protected String matricula;

    public Empregado(String nome, String cpf, int idade, String matricula) {
        super(nome, cpf, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public abstract double calcularSalario();

    public String toString() {
        return super.toString() + "\nMatricula: " + matricula;
    }
}
