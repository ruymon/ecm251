import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
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
        mostrador.setFont(new Font("Monospaced", Font.BOLD, 60));
        mostrador.setForeground(Color.BLUE);

        botaoTicTac = new JButton("TicTac");
        botaoHora = new JButton("Hora");
        botaoMinuto = new JButton("Minuto");

        JPanel painelBotoes = new JPanel(new GridLayout(1, 3));
        painelBotoes.add(botaoTicTac);
        painelBotoes.add(botaoHora);
        painelBotoes.add(botaoMinuto);

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        caixa.add(mostrador, BorderLayout.CENTER);
        caixa.add(painelBotoes, BorderLayout.SOUTH);

        botaoTicTac.addActionListener(this);
        botaoHora.addActionListener(this);
        botaoMinuto.addActionListener(this);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoTicTac) {
            relogio.ticTac();
        } else if (e.getSource() == botaoHora) {
            String entrada = JOptionPane.showInputDialog(this, "Informe a hora (0 a 23):");
            if (entrada != null) {
                try {
                    int h = Integer.parseInt(entrada);
                    if (h >= 0 && h <= 23) {
                        relogio.setHora(h);
                    } else {
                        JOptionPane.showMessageDialog(this, "Hora invalida. Deve ser entre 0 e 23.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Entrada invalida.");
                }
            }
        } else if (e.getSource() == botaoMinuto) {
            String entrada = JOptionPane.showInputDialog(this, "Informe o minuto (0 a 59):");
            if (entrada != null) {
                try {
                    int m = Integer.parseInt(entrada);
                    if (m >= 0 && m <= 59) {
                        relogio.setMinuto(m);
                    } else {
                        JOptionPane.showMessageDialog(this, "Minuto invalido. Deve ser entre 0 e 59.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Entrada invalida.");
                }
            }
        }
        mostrador.setText(relogio.mostra());
    }
}
