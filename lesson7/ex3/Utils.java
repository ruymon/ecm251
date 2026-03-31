public class Utils {
    public static final double MIN_TEMPERATURE_IN_CELSIUS = 15;
    public static final double MAX_TEMPERATURE_IN_CELSIUS = 28;
    public static final double TEMPERATURE_INCREMENT_IN_CELSIUS = 1;
    public static final double DEFAULT_TEMPERATURE_IN_CELSIUS = 20;

    public static void validateTemperature(double temperature) {
        if (temperature < MIN_TEMPERATURE_IN_CELSIUS || temperature > MAX_TEMPERATURE_IN_CELSIUS) {
            throw new IllegalArgumentException(
                "A temperatura deve estar entre " + MIN_TEMPERATURE_IN_CELSIUS
                + " e " + MAX_TEMPERATURE_IN_CELSIUS + " graus Celsius."
            );
        }
    }
}
