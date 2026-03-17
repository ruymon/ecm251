/**
 * Imprimir na tela todos os números de 1 a 100 e a soma deles;
 */

public class ex8 {
    public static void main(String[] args) {
        int sum = 0;
        int number = 1;

        while (number <= 100) {
            System.out.println(number);
            sum += number;
            number++;
        }

        System.out.println("Soma: " + sum);
    }
}
