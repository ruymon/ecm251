/**
 * Faça um algoritmo para imprimir na tela uma tabela de conversão de graus Celsius para graus Fahrenheit.
 * Deseja-se que o mesmo solicite ao usuário o limite inferior, o superior e o incremento.
 * Lembre-se que C = 5.(F-32)/9;
 */

import java.util.Scanner;

public class ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Limite inferior (°C): ");
        double lower = scanner.nextDouble();

        System.out.print("Limite superior (°C): ");
        double upper = scanner.nextDouble();

        System.out.print("Incremento: ");
        double increment = scanner.nextDouble();

        System.out.println("\nCelsius\t\tFahrenheit");
        System.out.println("------------------------------");

        double celsius = lower;
        while (celsius <= upper) {
            double fahrenheit = (celsius * 9.0 / 5.0) + 32;
            System.out.printf("%.1f\t\t%.1f%n", celsius, fahrenheit);
            celsius += increment;
        }

        scanner.close();
    }
}
