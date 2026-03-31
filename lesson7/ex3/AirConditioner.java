/**
 * A classe CondicionadorDeAr tem um atributo
 * termostato do tipo Termostato e um atributo boolean
 * chamado ligado. O construtor de CondicionadorDeAr não
 * recebe nenhum parâmetro, mas instancia um termostato
 * e o coloca ligado em false. Crie um método de acesso para
 * ligado e outro para termostato. Não precisa fazer os
 * métodos modificadores. Crie um método ligar(), que
 * muda ligado para true, e um desligar(), que muda ligado
 * para false.
 * Crie um método aumentarTemperatura(), que aumenta a
 * temperatura do termostato em um grau cada vez que é
 * chamado, até o limite de 28 graus. Crie um método
 * reduzirTemperatura(), que reduz a temperatura em um
 * grau cada vez que é chamado, até o limite de 15 graus.
 * Crie um método imprimirTemperatura(), que imprime a
 * temperatura atual. Não se esqueça de verificar se o
 * condicionador está ligado antes de aumentar ou diminuir
 * a temperatura ou imprimi-la.
 */

public class AirConditioner {
    private final TemperatureControl thermostat;
    private boolean isOn;

    public AirConditioner(TemperatureControl thermostat) {
        this.thermostat = thermostat;
        this.isOn = false;
    }

    public AirConditioner() {
        this(new Thermostat());
    }

    public boolean isOn() {
        return isOn;
    }

    public TemperatureControl getThermostat() {
        return thermostat;
    }

    public double getTemperature() {
        return thermostat.getTemperature();
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public boolean increaseTemperature() {
        if (!requireOn()) return false;

        try {
            double desired = thermostat.getTemperature() + Utils.TEMPERATURE_INCREMENT_IN_CELSIUS;
            thermostat.setTemperature(desired);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean decreaseTemperature() {
        if (!requireOn()) return false;

        try {
            double desired = thermostat.getTemperature() - Utils.TEMPERATURE_INCREMENT_IN_CELSIUS;
            thermostat.setTemperature(desired);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void printTemperature() {
        if (!requireOn()) return;
        System.out.println("A temperatura atual e: " + thermostat.getTemperature() + " graus Celsius.");
    }

    private boolean requireOn() {
        if (!this.isOn) {
            System.out.println("O condicionador de ar esta desligado.");
            return false;
        }
        return true;
    }
}
