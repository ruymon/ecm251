public class Desempregado extends PessoaFisica {
    private int mesesDesempregado;

    public Desempregado(String nome, String cpf, int idade, int mesesDesempregado) {
        super(nome, cpf, idade);
        this.mesesDesempregado = mesesDesempregado;
    }

    public int getMesesDesempregado() {
        return mesesDesempregado;
    }

    public void setMesesDesempregado(int mesesDesempregado) {
        this.mesesDesempregado = mesesDesempregado;
    }

    public String toString() {
        return "Tipo: Desempregado\n" + super.toString()
                + "\nMeses desempregado: " + mesesDesempregado;
    }
}
