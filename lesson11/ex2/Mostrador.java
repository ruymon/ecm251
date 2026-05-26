public class Mostrador {
    private int valor;
    private int limite;

    public Mostrador(int limite) {
        this.limite = limite;
        this.valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (valor >= 0 && valor < limite) {
            this.valor = valor;
        }
    }

    public int getLimite() {
        return limite;
    }

    public boolean incrementa() {
        valor++;
        if (valor >= limite) {
            valor = 0;
            return true;
        }
        return false;
    }

    public String mostra() {
        if (valor < 10) {
            return "0" + valor;
        }
        return "" + valor;
    }
}
