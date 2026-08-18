import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaTexto extends JFrame implements ActionListener {
    private JTextField texto;
    private JButton botaoMostrar;
    private JButton botaoLimpar;
    private JButton botaoSair;

    public TelaTexto() {
        super("Exercicio 1 - Texto");

        texto = new JTextField(20);
        botaoMostrar = new JButton("Mostrar");
        botaoLimpar = new JButton("Limpar");
        botaoSair = new JButton("Sair");

        JPanel painelTexto = new JPanel(new FlowLayout());
        painelTexto.add(new JLabel("Texto:"));
        painelTexto.add(texto);

        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(botaoMostrar);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoSair);

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        caixa.add(painelTexto, BorderLayout.CENTER);
        caixa.add(painelBotoes, BorderLayout.SOUTH);

        botaoMostrar.addActionListener(this);
        botaoLimpar.addActionListener(this);
        botaoSair.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();

        if (origem == botaoMostrar) {
            JOptionPane.showMessageDialog(this, texto.getText());
        } else if (origem == botaoLimpar) {
            texto.setText("");
        } else if (origem == botaoSair) {
            System.exit(0);
        }
    }
}
