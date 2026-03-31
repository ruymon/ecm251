/**
 * A classe Termostato tem um atributo temperatura. Seu
 * construtor não recebe parâmetros, mas instancia a
 * temperatura em 20 graus. Crie um método de acesso e
 * outro modificador.
 * 
 * Estes métodos devem respeitar os
 * limites estabelecidos
 */

public class Thermostat implements TemperatureControl {
    private double temperature;

    public Thermostat() {
        this.temperature = Utils.DEFAULT_TEMPERATURE_IN_CELSIUS;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(double temperature) {
        Utils.validateTemperature(temperature);
        this.temperature = temperature;
    }
}
