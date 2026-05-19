public class Utils {
    public static int calcularDigito(int numero) {
        if (numero <= 0 || numero > 9999) {
            throw new IllegalArgumentException("O numero deve ter no maximo 4 digitos e ser positivo.");
        }

        int primeiro = numero / 1000;
        int segundo = (numero / 100) % 10;
        int terceiro = (numero / 10) % 10;
        int quarto = numero % 10;

        int soma = primeiro * 4 + segundo * 6 + terceiro * 8 + quarto * 2;
        int digito = soma % 11;

        if (digito == 10) {
            return 0;
        }

        return digito;
    }
}
