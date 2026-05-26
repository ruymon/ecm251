import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
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

        acumulado = 0;
        operacao = ' ';
        novoNumero = true;

        visor = new JTextField("0");
        visor.setEditable(false);
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visor.setFont(new Font("Monospaced", Font.PLAIN, 22));

        digitos = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitos[i] = new JButton(String.valueOf(i));
        }
        botaoSoma = new JButton("+");
        botaoSubtracao = new JButton("-");
        botaoMultiplicacao = new JButton("*");
        botaoDivisao = new JButton("/");
        botaoIgual = new JButton("=");
        botaoLimpar = new JButton("C");

        JPanel painelTeclas = new JPanel(new GridLayout(4, 4, 2, 2));
        painelTeclas.add(digitos[7]);
        painelTeclas.add(digitos[8]);
        painelTeclas.add(digitos[9]);
        painelTeclas.add(botaoSoma);
        painelTeclas.add(digitos[4]);
        painelTeclas.add(digitos[5]);
        painelTeclas.add(digitos[6]);
        painelTeclas.add(botaoSubtracao);
        painelTeclas.add(digitos[1]);
        painelTeclas.add(digitos[2]);
        painelTeclas.add(digitos[3]);
        painelTeclas.add(botaoMultiplicacao);
        painelTeclas.add(digitos[0]);
        painelTeclas.add(botaoLimpar);
        painelTeclas.add(botaoIgual);
        painelTeclas.add(botaoDivisao);

        for (int i = 0; i < 10; i++) {
            digitos[i].addActionListener(this);
        }
        botaoSoma.addActionListener(this);
        botaoSubtracao.addActionListener(this);
        botaoMultiplicacao.addActionListener(this);
        botaoDivisao.addActionListener(this);
        botaoIgual.addActionListener(this);
        botaoLimpar.addActionListener(this);

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout(2, 2));
        caixa.add(visor, BorderLayout.NORTH);
        caixa.add(painelTeclas, BorderLayout.CENTER);

        setSize(320, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (origem == digitos[i]) {
                digitarNumero(i);
                return;
            }
        }

        if (origem == botaoSoma) {
            aplicarOperacao('+');
        } else if (origem == botaoSubtracao) {
            aplicarOperacao('-');
        } else if (origem == botaoMultiplicacao) {
            aplicarOperacao('*');
        } else if (origem == botaoDivisao) {
            aplicarOperacao('/');
        } else if (origem == botaoIgual) {
            calcularIgual();
        } else if (origem == botaoLimpar) {
            limpar();
        }
    }

    private void digitarNumero(int n) {
        if (novoNumero) {
            visor.setText(String.valueOf(n));
            novoNumero = false;
        } else {
            String atual = visor.getText();
            if (atual.equals("0")) {
                visor.setText(String.valueOf(n));
            } else {
                visor.setText(atual + n);
            }
        }
    }

    private void aplicarOperacao(char op) {
        long valor = Long.parseLong(visor.getText());
        if (operacao == ' ') {
            acumulado = valor;
        } else {
            acumulado = calcular(acumulado, valor, operacao);
            visor.setText(String.valueOf(acumulado));
        }
        operacao = op;
        novoNumero = true;
    }

    private void calcularIgual() {
        if (operacao == ' ') {
            return;
        }
        long valor = Long.parseLong(visor.getText());
        acumulado = calcular(acumulado, valor, operacao);
        visor.setText(String.valueOf(acumulado));
        operacao = ' ';
        novoNumero = true;
    }

    private long calcular(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    JOptionPane.showMessageDialog(this, "Divisao por zero.");
                    return 0;
                }
                return a / b;
        }
        return b;
    }

    private void limpar() {
        acumulado = 0;
        operacao = ' ';
        novoNumero = true;
        visor.setText("0");
    }
}
