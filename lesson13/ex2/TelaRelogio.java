import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRelogio extends JFrame implements ActionListener {
    private Relogio relogio;
    private JLabel mostrador;
    private JButton botaoTicTac;
    private JButton botaoHora;
    private JButton botaoMinuto;

    public TelaRelogio() {
        super("Exercicio 2 - Relogio");

        relogio = new Relogio();

        mostrador = new JLabel(relogio.mostra(), SwingConstants.CENTER);
        mostrador.setFont(new Font("Monospaced", Font.BOLD, 72));
        mostrador.setForeground(Color.BLUE);

        botaoTicTac = new JButton("TicTac");
        botaoHora = new JButton("Hora");
        botaoMinuto = new JButton("Minuto");

        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 2, 2));
        painelBotoes.add(botaoTicTac);
        painelBotoes.add(botaoHora);
        painelBotoes.add(botaoMinuto);

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout(5, 5));
        caixa.add(mostrador, BorderLayout.CENTER);
        caixa.add(painelBotoes, BorderLayout.SOUTH);

        botaoTicTac.addActionListener(this);
        botaoHora.addActionListener(this);
        botaoMinuto.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();

        if (origem == botaoTicTac) {
            relogio.ticTac();
        } else if (origem == botaoHora) {
            int hora = lerValor("Informe a hora", 23);
            if (hora >= 0) {
                relogio.setHora(hora);
            }
        } else if (origem == botaoMinuto) {
            int minuto = lerValor("Informe o minuto", 59);
            if (minuto >= 0) {
                relogio.setMinuto(minuto);
            }
        }

        mostrador.setText(relogio.mostra());
    }

    private int lerValor(String mensagem, int maximo) {
        String entrada = JOptionPane.showInputDialog(this, mensagem + " (0 a " + maximo + "):");
        if (entrada == null) {
            return -1;
        }
        try {
            int valor = Integer.parseInt(entrada.trim());
            if (valor >= 0 && valor <= maximo) {
                return valor;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada invalida.");
            return -1;
        }
        JOptionPane.showMessageDialog(this, "Valor fora do intervalo de 0 a " + maximo + ".");
        return -1;
    }
}
