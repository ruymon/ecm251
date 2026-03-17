/**
 * Imprimir em tela os 20 primeiros números pares, a partir de 0, inclusive;
 */

public class ex1 {
    public static void main(String[] args) {
        int count = 0;
        int number = 0;

        while (count < 20) {
            System.out.println(number);
            number += 2;
            count++;
        }
    }
}
