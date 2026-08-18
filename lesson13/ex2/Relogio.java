public class Relogio {
    private Mostrador hora;
    private Mostrador minuto;

    public Relogio() {
        hora = new Mostrador(24);
        minuto = new Mostrador(60);
    }

    public void ticTac() {
        if (minuto.incrementa()) {
            hora.incrementa();
        }
    }

    public void setHora(int h) {
        hora.setValor(h);
    }

    public void setMinuto(int m) {
        minuto.setValor(m);
    }

    public int getHora() {
        return hora.getValor();
    }

    public int getMinuto() {
        return minuto.getValor();
    }

    public String mostra() {
        return hora.mostra() + ":" + minuto.mostra();
    }
}
