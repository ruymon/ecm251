/**
 * Crie a classe TestCase, com o método main(). Neste
 * método você deve instanciar um CondicionadorDeAr,
 * aumentar a temperatura para 30 graus (receber
 * mensagem de erro), reduzir a temperatura para 10 graus
 * (receber mensagem de erro). Aumentar a temperatura
 * para 25 graus e imprimir a temperatura.
 */

public class TestCase {
    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner();
        ac.turnOn();

        System.out.println("=== Aumentando para 30 graus ===");
        while (ac.increaseTemperature());

        System.out.println("\n=== Reduzindo para 10 graus ===");
        while (ac.decreaseTemperature());

        System.out.println("\n=== Aumentando para 25 graus ===");
        while (ac.getTemperature() < 25) {
            ac.increaseTemperature();
        }

        System.out.println();
        ac.printTemperature();
    }
}
