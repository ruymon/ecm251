import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCalculadora extends JFrame implements ActionListener {
    private JTextField visor;
    private JButton[] digitos;
    private JButton botaoSoma;
    private JButton botaoSubtracao;
    private JButton botaoMultiplicacao;
    private JButton botaoDivisao;
    private JButton botaoIgual;
    private JButton botaoLimpar;

    private long acumulado;
    private char operacao;
    private boolean novoNumero;

    public TelaCalculadora() {
        super("Calculadora");

        visor = new JTextField("0", 12);
        visor.setEditable(false);
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visor.setFont(new Font("Monospaced", Font.PLAIN, 22));

        digitos = new JButton[10];
        for (int i = 0; i < digitos.length; i++) {
            digitos[i] = new JButton(String.valueOf(i));
        }

        botaoSoma = new JButton("+");
        botaoSubtracao = new JButton("-");
        botaoMultiplicacao = new JButton("*");
        botaoDivisao = new JButton("/");
        botaoIgual = new JButton("=");
        botaoLimpar = new JButton("C");

        JPanel teclado = new JPanel(new GridLayout(4, 4, 2, 2));
        JButton[] teclas = {
                digitos[7], digitos[8], digitos[9], botaoSoma,
                digitos[4], digitos[5], digitos[6], botaoSubtracao,
                digitos[1], digitos[2], digitos[3], botaoMultiplicacao,
                digitos[0], botaoLimpar, botaoIgual, botaoDivisao
        };
        for (int i = 0; i < teclas.length; i++) {
            teclas[i].addActionListener(this);
            teclado.add(teclas[i]);
        }

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout(2, 2));
        caixa.add(visor, BorderLayout.NORTH);
        caixa.add(teclado, BorderLayout.CENTER);

        limpar();

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();

        for (int i = 0; i < digitos.length; i++) {
            if (origem == digitos[i]) {
                digitar(i);
                return;
            }
        }

        if (origem == botaoSoma) {
            acumular('+');
        } else if (origem == botaoSubtracao) {
            acumular('-');
        } else if (origem == botaoMultiplicacao) {
            acumular('*');
        } else if (origem == botaoDivisao) {
            acumular('/');
        } else if (origem == botaoIgual) {
            acumular(' ');
        } else if (origem == botaoLimpar) {
            limpar();
        }
    }

    private void digitar(int digito) {
        if (novoNumero || visor.getText().equals("0")) {
            visor.setText(String.valueOf(digito));
            novoNumero = false;
        } else {
            visor.setText(visor.getText() + digito);
        }
    }

    private void acumular(char proxima) {
        if (novoNumero && operacao != ' ') {
            operacao = proxima;
            return;
        }

        long valor = Long.parseLong(visor.getText());

        if (operacao == '/' && valor == 0) {
            JOptionPane.showMessageDialog(this, "Divisao por zero.");
            limpar();
            return;
        }

        if (operacao == ' ') {
            acumulado = valor;
        } else {
            acumulado = calcular(acumulado, valor, operacao);
            visor.setText(String.valueOf(acumulado));
        }

        operacao = proxima;
        novoNumero = true;
    }

    private long calcular(long a, long b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return a / b;
        }
    }

    private void limpar() {
        acumulado = 0;
        operacao = ' ';
        novoNumero = true;
        visor.setText("0");
    }
}
