/**
 * Escrever um algoritmo que lê̂ 2 números reais. A seguir, é apresentado, para o usuário, o menu a seguir:
 * 
 * “Operações Disponíveis:
 * 1. Adição;
 * 2. Subtração;
 * 3. Multiplicação;
 * 4. Divisão;
 * 9. Sair do Programa.
 * Digite o número de ordem da opção desejada: “
 * 
 * Se a opção for 1, o algoritmo deve somar os dois valores lidos; 
 * se for 2, o algoritmo deve fazer o primeiro valor menos o segundo; 
 * se for 3, o algoritmo deve multiplicar os valores lidos;
 * se for 4, o algoritmo deve dividir o primeiro pelo segundo valor lido, desde que este não seja zero (o algoritmo deve ter tratamento especial para este caso).
 * 
 * O algoritmo deve escrever o resultado da operação escolhida. 
 * Se o usuário digitar 9, o algoritmo deve ser encerrado.
 * Enquanto o valor da opção 9 não for digitado, o menu deve ser apresentado novamente.
 */

import java.util.Scanner;

public class ex25 {
    final static int ADD = 1;
    final static int SUBTRACT = 2;
    final static int MULTIPLY = 3;
    final static int DIVIDE = 4;
    final static int EXIT = 9;

    public static void displayMenu() {
        System.out.println("Operações Disponíveis:");
        System.out.printf("%d. Adição\n", ADD);
        System.out.printf("%d. Subtração\n", SUBTRACT);
        System.out.printf("%d. Multiplicação\n", MULTIPLY);
        System.out.printf("%d. Divisão\n", DIVIDE);
        System.out.printf("%d. Sair do Programa\n\n", EXIT);
    }

    public static double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            System.out.println("Erro: Divisão por zero é indefinida");
            return Double.NaN;
        }
        return firstNumber / secondNumber;
    }

    public static double executeOperation(int userOption, double firstNumber, double secondNumber) {
        switch (userOption) {
            case ADD:
                return add(firstNumber, secondNumber);
            case SUBTRACT:
                return subtract(firstNumber, secondNumber);
            case MULTIPLY:
                return multiply(firstNumber, secondNumber);
            case DIVIDE:
                return divide(firstNumber, secondNumber);
            default:
                System.out.println("Opção inválida");
                return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double firstNumber = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double secondNumber = scanner.nextDouble();

        int userOption = 0;
        while (userOption != EXIT) {
            displayMenu();
            System.out.print("Digite a opção desejada: ");
            userOption = scanner.nextInt();

            if (userOption == EXIT) {
                System.out.println("Saindo do programa...");
                break;
            }

            double result = executeOperation(userOption, firstNumber, secondNumber);
            if (!Double.isNaN(result)) {
                System.out.println("Resultado: " + result);
            }
        }

        scanner.close();
    }
}