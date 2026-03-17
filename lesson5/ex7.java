/** 
 * Imprimir na tela o produto de todos os números de 120 a 300;
 */

import java.math.BigInteger;

public class ex7 {
    public static void main(String[] args) {
        BigInteger product = BigInteger.ONE;
        int number = 120;

        while (number <= 300) {
            product = product.multiply(BigInteger.valueOf(number));
            number++;
        }

        System.out.println("Produto dos números de 120 a 300: " + product);
    }
}
