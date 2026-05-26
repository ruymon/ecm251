import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaTexto extends JFrame implements ActionListener {
    private JLabel etiqueta;
    private JTextField texto;
    private JButton botaoMostrar;
    private JButton botaoLimpar;
    private JButton botaoSair;

    public TelaTexto() {
        super("Exercicio 1");

        etiqueta = new JLabel("Texto: ");
        texto = new JTextField("", 15);
        botaoMostrar = new JButton("Mostrar");
        botaoLimpar = new JButton("Limpar");
        botaoSair = new JButton("Sair");

        Container caixa = getContentPane();
        caixa.setLayout(new FlowLayout());
        caixa.add(etiqueta);
        caixa.add(texto);
        caixa.add(botaoMostrar);
        caixa.add(botaoLimpar);
        caixa.add(botaoSair);

        botaoMostrar.addActionListener(this);
        botaoLimpar.addActionListener(this);
        botaoSair.addActionListener(this);

        setSize(360, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoMostrar) {
            JOptionPane.showMessageDialog(this, texto.getText());
        } else if (e.getSource() == botaoLimpar) {
            texto.setText("");
        } else if (e.getSource() == botaoSair) {
            System.exit(0);
        }
    }
}
