/**
 * Crie a classe Carro com os atributos: marca, modelo e ano de fabricação.
 * Implemente os métodos necessários.
 * Na classe de teste, instancie um carro com dados fornecidos via JOptionPane e exiba-os ao
 * final.
 */

import javax.swing.JOptionPane;

class Carro {
    private String marca;
    private String modelo;
    private int anoFabricacao;

    public Carro(String marca, String modelo, int anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String toString() {
        return "Marca: " + marca + "\nModelo: " + modelo + "\nAno de fabricação: " + anoFabricacao;
    }
}

public class ex2 {
    public static void main(String[] args) {
        String marca = JOptionPane.showInputDialog(null, "Marca do carro:", "Carro", JOptionPane.QUESTION_MESSAGE);
        String modelo = JOptionPane.showInputDialog(null, "Modelo:", "Carro", JOptionPane.QUESTION_MESSAGE);
        String anoStr = JOptionPane.showInputDialog(null, "Ano de fabricação:", "Carro", JOptionPane.QUESTION_MESSAGE);

        int ano = Integer.parseInt(anoStr.trim());
        Carro carro = new Carro(marca, modelo, ano);

        JOptionPane.showMessageDialog(null, carro.toString(), "Dados do carro", JOptionPane.INFORMATION_MESSAGE);
    }
}
