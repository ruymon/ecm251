public abstract class Empregado {
    protected String nome;
    protected String matricula;

    public Empregado(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public abstract double calcularSalario();

    public String toString() {
        return "Nome: " + nome + "\nMatricula: " + matricula;
    }
}
