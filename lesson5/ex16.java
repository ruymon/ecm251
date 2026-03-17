/**
 * Faça um algoritmo para imprimir na tela uma tabela de conversão de polegadas para centímetros. 
 * Deseja-se que a tabela conste de valores desde 1 até 20 polegadas. Lembre-se que 1 polegada equivale a 2,54 cm
 */

public class ex16 {
    public static void main(String[] args) {
        System.out.println("Polegadas\tCentímetros");
        System.out.println("------------------------------");

        for (int inches = 1; inches <= 20; inches++) {
            double cm = inches * 2.54;
            System.out.printf("%d\t\t%.2f%n", inches, cm);
        }
    }
}
