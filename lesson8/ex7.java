/**
 * Crie a classe Celular com os atributos: marca, modelo e capacidade de armazenamento (em GB).
 * Na classe de teste, leia os dados via JOptionPane e mostre-os formatados como uma ficha
 * técnica.
 */

import javax.swing.JOptionPane;

class Celular {
    private String marca;
    private String modelo;
    private int capacidadeGb;

    public Celular(String marca, String modelo, int capacidadeGb) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadeGb = capacidadeGb;
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

    public int getCapacidadeGb() {
        return capacidadeGb;
    }

    public void setCapacidadeGb(int capacidadeGb) {
        this.capacidadeGb = capacidadeGb;
    }

    public String fichaTecnica() {
        return "╔══════════════════════════════════╗\n"
                + "║       FICHA TÉCNICA — CELULAR     ║\n"
                + "╠══════════════════════════════════╣\n"
                + "║ Marca:        " + String.format("%-18s", marca) + "║\n"
                + "║ Modelo:       " + String.format("%-18s", modelo) + "║\n"
                + "║ Armazenamento:" + String.format("%-18s", capacidadeGb + " GB") + "║\n"
                + "╚══════════════════════════════════╝";
    }
}

public class ex7 {
    public static void main(String[] args) {
        String marca = JOptionPane.showInputDialog(null, "Marca:", "Celular", JOptionPane.QUESTION_MESSAGE);
        String modelo = JOptionPane.showInputDialog(null, "Modelo:", "Celular", JOptionPane.QUESTION_MESSAGE);
        String gbStr = JOptionPane.showInputDialog(null, "Capacidade de armazenamento (GB):", "Celular",
                JOptionPane.QUESTION_MESSAGE);

        int gb = Integer.parseInt(gbStr.trim());
        Celular celular = new Celular(marca, modelo, gb);

        JOptionPane.showMessageDialog(null, celular.fichaTecnica(), "Ficha técnica", JOptionPane.INFORMATION_MESSAGE);
    }
}
