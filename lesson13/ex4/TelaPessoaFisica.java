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

public class TelaPessoaFisica extends JFrame implements ActionListener {
    private static final String[] TIPOS = {"Desempregado", "Mensalista", "Comissionado", "Horista", "Tarefeiro"};

    private JTextField nome;
    private JTextField cpf;
    private JTextField idade;
    private JTextField matricula;
    private JTextField mesesDesempregado;
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

    public TelaPessoaFisica() {
        super("Exercicio 4 - Pessoa Fisica");

        nome = new JTextField(15);
        cpf = new JTextField(15);
        idade = new JTextField(15);
        matricula = new JTextField(15);
        mesesDesempregado = new JTextField(15);
        salarioMensal = new JTextField(15);
        salarioBase = new JTextField(15);
        vendas = new JTextField(15);
        percentual = new JTextField(15);
        horasTrabalhadas = new JTextField(15);
        valorHora = new JTextField(15);
        tarefasFeitas = new JTextField(15);
        valorTarefa = new JTextField(15);

        campos = new JTextField[]{nome, cpf, idade, matricula, mesesDesempregado, salarioMensal,
                salarioBase, vendas, percentual, horasTrabalhadas, valorHora, tarefasFeitas, valorTarefa};

        tipo = new JComboBox<String>(TIPOS);

        botaoCalcular = new JButton("Calcular");
        botaoLimpar = new JButton("Limpar");
        botaoSair = new JButton("Sair");

        JPanel painelComum = criarPainel(
                new String[]{"Nome:", "CPF:", "Idade:", "Matricula:", "Tipo:"},
                new JComponent[]{nome, cpf, idade, matricula, tipo});

        cartoes = new JPanel(new CardLayout());
        cartoes.add(criarPainel(
                new String[]{"Meses desempregado:"},
                new JComponent[]{mesesDesempregado}), TIPOS[0]);
        cartoes.add(criarPainel(
                new String[]{"Salario mensal:"},
                new JComponent[]{salarioMensal}), TIPOS[1]);
        cartoes.add(criarPainel(
                new String[]{"Salario base:", "Vendas:", "Percentual (%):"},
                new JComponent[]{salarioBase, vendas, percentual}), TIPOS[2]);
        cartoes.add(criarPainel(
                new String[]{"Horas trabalhadas:", "Valor por hora:"},
                new JComponent[]{horasTrabalhadas, valorHora}), TIPOS[3]);
        cartoes.add(criarPainel(
                new String[]{"Tarefas feitas:", "Valor por tarefa:"},
                new JComponent[]{tarefasFeitas, valorTarefa}), TIPOS[4]);

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
        matricula.setEnabled(tipo.getSelectedIndex() > 0);
    }

    private void calcular() {
        try {
            JOptionPane.showMessageDialog(this, criarPessoa().toString());
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

    private PessoaFisica criarPessoa() {
        String n = nome.getText().trim();
        String c = cpf.getText().trim();

        if (n.isEmpty() || c.isEmpty()) {
            throw new IllegalArgumentException("Nome e CPF sao obrigatorios.");
        }

        int i = lerInt(idade);

        if (tipo.getSelectedIndex() == 0) {
            return new Desempregado(n, c, i, lerInt(mesesDesempregado));
        }

        String m = matricula.getText().trim();
        if (m.isEmpty()) {
            throw new IllegalArgumentException("Matricula e obrigatoria para empregados.");
        }

        switch (tipo.getSelectedIndex()) {
            case 1:
                return new Mensalista(n, c, i, m, lerDouble(salarioMensal));
            case 2:
                return new Comissionado(n, c, i, m, lerDouble(salarioBase), lerDouble(vendas), lerDouble(percentual));
            case 3:
                return new Horista(n, c, i, m, lerDouble(horasTrabalhadas), lerDouble(valorHora));
            default:
                return new Tarefeiro(n, c, i, m, lerInt(tarefasFeitas), lerDouble(valorTarefa));
        }
    }

    private double lerDouble(JTextField campo) {
        return Double.parseDouble(campo.getText().trim());
    }

    private int lerInt(JTextField campo) {
        return Integer.parseInt(campo.getText().trim());
    }
}
