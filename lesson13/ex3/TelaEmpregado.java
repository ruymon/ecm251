import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEmpregado extends JFrame implements ActionListener {
    private static final String[] TIPOS = {"Mensalista", "Comissionado", "Horista", "Tarefeiro"};

    private JTextField nome;
    private JTextField matricula;
    private JTextField salarioMensal;
    private JTextField salarioBase;
    private JTextField vendas;
    private JTextField percentual;
    private JTextField horasTrabalhadas;
    private JTextField valorHora;
    private JTextField tarefasFeitas;
    private JTextField valorTarefa;
    private JTextField[] campos;
    private JComboBox<String> tipo;
    private JPanel cartoes;
    private JButton botaoCalcular;
    private JButton botaoLimpar;
    private JButton botaoSair;

    public TelaEmpregado() {
        super("Exercicio 3 - Empregado");

        nome = new JTextField(15);
        matricula = new JTextField(15);
        salarioMensal = new JTextField(15);
        salarioBase = new JTextField(15);
        vendas = new JTextField(15);
        percentual = new JTextField(15);
        horasTrabalhadas = new JTextField(15);
        valorHora = new JTextField(15);
        tarefasFeitas = new JTextField(15);
        valorTarefa = new JTextField(15);

        campos = new JTextField[]{nome, matricula, salarioMensal, salarioBase, vendas,
                percentual, horasTrabalhadas, valorHora, tarefasFeitas, valorTarefa};

        tipo = new JComboBox<String>(TIPOS);

        botaoCalcular = new JButton("Calcular");
        botaoLimpar = new JButton("Limpar");
        botaoSair = new JButton("Sair");

        JPanel painelComum = criarPainel(
                new String[]{"Nome:", "Matricula:", "Tipo:"},
                new JComponent[]{nome, matricula, tipo});

        cartoes = new JPanel(new CardLayout());
        cartoes.add(criarPainel(
                new String[]{"Salario mensal:"},
                new JComponent[]{salarioMensal}), TIPOS[0]);
        cartoes.add(criarPainel(
                new String[]{"Salario base:", "Vendas:", "Percentual (%):"},
                new JComponent[]{salarioBase, vendas, percentual}), TIPOS[1]);
        cartoes.add(criarPainel(
                new String[]{"Horas trabalhadas:", "Valor por hora:"},
                new JComponent[]{horasTrabalhadas, valorHora}), TIPOS[2]);
        cartoes.add(criarPainel(
                new String[]{"Tarefas feitas:", "Valor por tarefa:"},
                new JComponent[]{tarefasFeitas, valorTarefa}), TIPOS[3]);

        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(botaoCalcular);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoSair);

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        caixa.add(painelComum, BorderLayout.NORTH);
        caixa.add(cartoes, BorderLayout.CENTER);
        caixa.add(painelBotoes, BorderLayout.SOUTH);

        tipo.addActionListener(this);
        botaoCalcular.addActionListener(this);
        botaoLimpar.addActionListener(this);
        botaoSair.addActionListener(this);

        mostrarCartao();

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();

        if (origem == tipo) {
            mostrarCartao();
        } else if (origem == botaoCalcular) {
            calcular();
        } else if (origem == botaoLimpar) {
            limpar();
        } else if (origem == botaoSair) {
            System.exit(0);
        }
    }

    private JPanel criarPainel(String[] etiquetas, JComponent[] entradas) {
        JPanel painel = new JPanel(new GridLayout(0, 2, 5, 5));
        painel.setBorder(new EmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < etiquetas.length; i++) {
            painel.add(new JLabel(etiquetas[i]));
            painel.add(entradas[i]);
        }
        return painel;
    }

    private void mostrarCartao() {
        CardLayout layout = (CardLayout) cartoes.getLayout();
        layout.show(cartoes, (String) tipo.getSelectedItem());
    }

    private void calcular() {
        try {
            JOptionPane.showMessageDialog(this, criarEmpregado().toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preencha os campos numericos com valores validos.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void limpar() {
        for (int i = 0; i < campos.length; i++) {
            campos[i].setText("");
        }
    }

    private Empregado criarEmpregado() {
        String n = nome.getText().trim();
        String m = matricula.getText().trim();

        if (n.isEmpty() || m.isEmpty()) {
            throw new IllegalArgumentException("Nome e matricula sao obrigatorios.");
        }

        switch (tipo.getSelectedIndex()) {
            case 0:
                return new Mensalista(n, m, lerDouble(salarioMensal));
            case 1:
                return new Comissionado(n, m, lerDouble(salarioBase), lerDouble(vendas), lerDouble(percentual));
            case 2:
                return new Horista(n, m, lerDouble(horasTrabalhadas), lerDouble(valorHora));
            default:
                return new Tarefeiro(n, m, lerInt(tarefasFeitas), lerDouble(valorTarefa));
        }
    }

    private double lerDouble(JTextField campo) {
        return Double.parseDouble(campo.getText().trim());
    }

    private int lerInt(JTextField campo) {
        return Integer.parseInt(campo.getText().trim());
    }
}
