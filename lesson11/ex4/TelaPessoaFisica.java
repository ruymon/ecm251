import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPessoaFisica extends JFrame implements ActionListener {
    private JTextField nome;
    private JTextField cpf;
    private JTextField idade;
    private JTextField mesesDesempregado;
    private JTextField matricula;
    private JTextField salarioMensal;
    private JTextField salarioBase;
    private JTextField vendas;
    private JTextField percentual;
    private JTextField horas;
    private JTextField valorHora;
    private JTextField tarefas;
    private JTextField valorTarefa;
    private JButton botaoCalcular;
    private JButton botaoLimpar;
    private JButton botaoSair;

    public TelaPessoaFisica() {
        super("Exercicio 4 - PessoaFisica");

        nome = new JTextField(15);
        cpf = new JTextField(15);
        idade = new JTextField(5);
        mesesDesempregado = new JTextField(10);
        matricula = new JTextField(10);
        salarioMensal = new JTextField(10);
        salarioBase = new JTextField(10);
        vendas = new JTextField(10);
        percentual = new JTextField(10);
        horas = new JTextField(10);
        valorHora = new JTextField(10);
        tarefas = new JTextField(10);
        valorTarefa = new JTextField(10);

        botaoCalcular = new JButton("Calcular");
        botaoLimpar = new JButton("Limpar");
        botaoSair = new JButton("Sair");

        JPanel painelCampos = new JPanel(new GridLayout(0, 2, 5, 5));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(nome);
        painelCampos.add(new JLabel("CPF:"));
        painelCampos.add(cpf);
        painelCampos.add(new JLabel("Idade:"));
        painelCampos.add(idade);

        painelCampos.add(new JLabel("--- Desempregado ---"));
        painelCampos.add(new JLabel(""));
        painelCampos.add(new JLabel("Meses desempregado:"));
        painelCampos.add(mesesDesempregado);

        painelCampos.add(new JLabel("--- Empregado ---"));
        painelCampos.add(new JLabel(""));
        painelCampos.add(new JLabel("Matricula:"));
        painelCampos.add(matricula);

        painelCampos.add(new JLabel("- Mensalista -"));
        painelCampos.add(new JLabel(""));
        painelCampos.add(new JLabel("Salario mensal:"));
        painelCampos.add(salarioMensal);

        painelCampos.add(new JLabel("- Comissionado -"));
        painelCampos.add(new JLabel(""));
        painelCampos.add(new JLabel("Salario base:"));
        painelCampos.add(salarioBase);
        painelCampos.add(new JLabel("Vendas:"));
        painelCampos.add(vendas);
        painelCampos.add(new JLabel("Percentual (%):"));
        painelCampos.add(percentual);

        painelCampos.add(new JLabel("- Horista -"));
        painelCampos.add(new JLabel(""));
        painelCampos.add(new JLabel("Horas trabalhadas:"));
        painelCampos.add(horas);
        painelCampos.add(new JLabel("Valor por hora:"));
        painelCampos.add(valorHora);

        painelCampos.add(new JLabel("- Tarefeiro -"));
        painelCampos.add(new JLabel(""));
        painelCampos.add(new JLabel("Tarefas feitas:"));
        painelCampos.add(tarefas);
        painelCampos.add(new JLabel("Valor por tarefa:"));
        painelCampos.add(valorTarefa);

        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(botaoCalcular);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoSair);

        JLabel instrucao = new JLabel("Para Desempregado, preencha o campo 'Meses desempregado'. Para Empregado, preencha matricula e um dos grupos de salario.", JLabel.CENTER);

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        caixa.add(instrucao, BorderLayout.NORTH);
        caixa.add(painelCampos, BorderLayout.CENTER);
        caixa.add(painelBotoes, BorderLayout.SOUTH);

        botaoCalcular.addActionListener(this);
        botaoLimpar.addActionListener(this);
        botaoSair.addActionListener(this);

        setSize(550, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoSair) {
            System.exit(0);
        } else if (e.getSource() == botaoLimpar) {
            nome.setText("");
            cpf.setText("");
            idade.setText("");
            mesesDesempregado.setText("");
            matricula.setText("");
            salarioMensal.setText("");
            salarioBase.setText("");
            vendas.setText("");
            percentual.setText("");
            horas.setText("");
            valorHora.setText("");
            tarefas.setText("");
            valorTarefa.setText("");
        } else if (e.getSource() == botaoCalcular) {
            try {
                PessoaFisica pf = criarPessoa();
                if (pf != null) {
                    JOptionPane.showMessageDialog(this, pf.toString());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: valor numerico invalido.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    private PessoaFisica criarPessoa() {
        String n = nome.getText().trim();
        String c = cpf.getText().trim();
        String i = idade.getText().trim();

        if (n.isEmpty() || c.isEmpty() || i.isEmpty()) {
            throw new IllegalArgumentException("Nome, CPF e idade sao obrigatorios.");
        }

        int idadeNum = Integer.parseInt(i);

        boolean temDesempregado = !mesesDesempregado.getText().trim().isEmpty();
        boolean temMatricula = !matricula.getText().trim().isEmpty();

        if (temDesempregado && temMatricula) {
            throw new IllegalArgumentException("Preencha apenas Desempregado OU Empregado.");
        }

        if (temDesempregado) {
            return new Desempregado(n, c, idadeNum,
                    Integer.parseInt(mesesDesempregado.getText().trim()));
        }

        if (!temMatricula) {
            throw new IllegalArgumentException("Preencha 'Meses desempregado' ou 'Matricula' + um grupo de salario.");
        }

        String m = matricula.getText().trim();

        boolean temMensalista = !salarioMensal.getText().trim().isEmpty();
        boolean temComissionado = !salarioBase.getText().trim().isEmpty()
                || !vendas.getText().trim().isEmpty()
                || !percentual.getText().trim().isEmpty();
        boolean temHorista = !horas.getText().trim().isEmpty()
                || !valorHora.getText().trim().isEmpty();
        boolean temTarefeiro = !tarefas.getText().trim().isEmpty()
                || !valorTarefa.getText().trim().isEmpty();

        int grupos = (temMensalista ? 1 : 0) + (temComissionado ? 1 : 0)
                + (temHorista ? 1 : 0) + (temTarefeiro ? 1 : 0);

        if (grupos == 0) {
            throw new IllegalArgumentException("Preencha um grupo de campos para definir o tipo de empregado.");
        }
        if (grupos > 1) {
            throw new IllegalArgumentException("Preencha apenas um grupo de campos de salario.");
        }

        if (temMensalista) {
            return new Mensalista(n, c, idadeNum, m,
                    Double.parseDouble(salarioMensal.getText().trim()));
        }
        if (temComissionado) {
            return new Comissionado(n, c, idadeNum, m,
                    Double.parseDouble(salarioBase.getText().trim()),
                    Double.parseDouble(vendas.getText().trim()),
                    Double.parseDouble(percentual.getText().trim()));
        }
        if (temHorista) {
            return new Horista(n, c, idadeNum, m,
                    Double.parseDouble(horas.getText().trim()),
                    Double.parseDouble(valorHora.getText().trim()));
        }
        return new Tarefeiro(n, c, idadeNum, m,
                Integer.parseInt(tarefas.getText().trim()),
                Double.parseDouble(valorTarefa.getText().trim()));
    }
}
