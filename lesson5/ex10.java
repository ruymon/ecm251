/**
 * Uma empresa de fornecimento de energia elétrica faz a leitura mensal dos medidores de consumo. 
 * Para cada consumidor são digitados os seguintes dados: código do consumidor, quantidade de kWh 
 * consumidos durante o mês, tipo do consumidor. 
 * Os tipos podem ser 
 * 1 - residencial, preço por kWh = R$ 0,3; 
 * 2 - comercial, preço por kWh = 0,5; 
 * 3 - industrial, preço por kWh = 0,7. 
 * 
 * Os dados devem ser lidos até que seja encontrado um consumidor com código 0 (zero). 
 * Calcular e imprimir o custo total para cada consumidor, o total de consumo para os três tipos de consumidor, 
 * a média de consumo dos tipos 1 e 2
 */

import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalResidencial = 0;
        double totalComercial = 0;
        double totalIndustrial = 0;
        int countResidencial = 0;
        int countComercial = 0;

        while (true) {
            System.out.print("Código do consumidor (0 para sair): ");
            int code = scanner.nextInt();

            if (code == 0) {
                break;
            }

            System.out.print("Quantidade de kWh consumidos: ");
            double kwh = scanner.nextDouble();

            System.out.print("Tipo do consumidor (1-Residencial, 2-Comercial, 3-Industrial): ");
            int type = scanner.nextInt();

            double cost = 0;

            switch (type) {
                case 1:
                    cost = kwh * 0.3;
                    totalResidencial += kwh;
                    countResidencial++;
                    break;
                case 2:
                    cost = kwh * 0.5;
                    totalComercial += kwh;
                    countComercial++;
                    break;
                case 3:
                    cost = kwh * 0.7;
                    totalIndustrial += kwh;
                    break;
                default:
                    System.out.println("Tipo inválido!");
                    continue;
            }

            System.out.printf("Consumidor %d - Custo total: R$ %.2f%n", code, cost);
        }

        System.out.println("\n--- Totais ---");
        System.out.printf("Total consumo Residencial: %.2f kWh%n", totalResidencial);
        System.out.printf("Total consumo Comercial: %.2f kWh%n", totalComercial);
        System.out.printf("Total consumo Industrial: %.2f kWh%n", totalIndustrial);

        int totalTipo1e2 = countResidencial + countComercial;
        if (totalTipo1e2 > 0) {
            double media = (totalResidencial + totalComercial) / totalTipo1e2;
            System.out.printf("Média de consumo dos tipos 1 e 2: %.2f kWh%n", media);
        } else {
            System.out.println("Nenhum consumidor dos tipos 1 e 2 foi cadastrado.");
        }

        scanner.close();
    }
}
