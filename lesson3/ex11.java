/**
 * Crie um algoritmo que embaralhe mensagens fazendo:
 * - leia três frases, separe cada uma delas ao meio.
 * Então junte nesta ordem: 
 * - primeira metade da segunda,
 * - segunda metade da terceira,
 * - segunda metade da segunda,
 * - primeira metade da primeira,
 * - primeira metade da terceira,
 * - segunda metade da primeira. 
 * - Concatene então as três frases originais e imprima o resultado. 
 * - Na linha de baixo, escreva a frase embaralhada e compare o resultado
 */

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a primeira frase: ");
        String firstSentence = scanner.nextLine();
        System.out.println("Digite a segunda frase: ");
        String secondSentence = scanner.nextLine();
        System.out.println("Digite a terceira frase: ");
        String thirdSentence = scanner.nextLine();

        String firstHalfOfFirstSentence = firstSentence.substring(0, firstSentence.length() / 2);
        String secondHalfOfFirstSentence = firstSentence.substring(firstSentence.length() / 2);

        String firstHalfOfSecondSentence = secondSentence.substring(0, secondSentence.length() / 2);
        String secondHalfOfSecondSentence = secondSentence.substring(secondSentence.length() / 2);

        String firstHalfOfThirdSentence = thirdSentence.substring(0, thirdSentence.length() / 2);
        String secondHalfOfThirdSentence = thirdSentence.substring(thirdSentence.length() / 2);

        String shuffledSentence = firstHalfOfSecondSentence + secondHalfOfThirdSentence + secondHalfOfSecondSentence + firstHalfOfFirstSentence + firstHalfOfThirdSentence + secondHalfOfFirstSentence;

        System.out.println("A frase original é: " + firstSentence + " " + secondSentence + " " + thirdSentence);
        System.out.println("A frase embaralhada é: " + shuffledSentence);
    }
}