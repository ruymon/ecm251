import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaExemplo extends JFrame implements ActionListener {
    private JButton calculateButton;
    private JTextField valueField;
    private JLabel valueLabel;
    private JMenu languageMenu;
    private JMenuItem portugueseItem;
    private JMenuItem englishItem;
    private JMenuItem frenchItem;
    private JMenuItem italianItem;
    private ResourceBundle bundle;

    public TelaExemplo() {
        valueLabel = new JLabel();
        valueField = new JTextField(10);
        calculateButton = new JButton();

        Container content = getContentPane();
        content.setLayout(new FlowLayout());
        content.add(valueLabel);
        content.add(valueField);
        content.add(calculateButton);

        portugueseItem = new JMenuItem("Português");
        englishItem = new JMenuItem("English");
        frenchItem = new JMenuItem("Français");
        italianItem = new JMenuItem("Italiano");

        languageMenu = new JMenu();
        languageMenu.add(portugueseItem);
        languageMenu.add(englishItem);
        languageMenu.add(frenchItem);
        languageMenu.add(italianItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(languageMenu);
        setJMenuBar(menuBar);

        calculateButton.addActionListener(this);
        portugueseItem.addActionListener(this);
        englishItem.addActionListener(this);
        frenchItem.addActionListener(this);
        italianItem.addActionListener(this);

        loadLanguage(Locale.of("pt", "BR"));

        setSize(350, 120);
        setVisible(true);
    }

 
    private void loadLanguage(Locale locale) {
        bundle = ResourceBundle.getBundle("Ex1", locale);
        setTitle(bundle.getString("tela1.titulo"));
        languageMenu.setText(bundle.getString("menu.idioma"));
        valueLabel.setText(bundle.getString("tela1.rotulo.valor") + ":");
        calculateButton.setText(bundle.getString("tela1.botao.calcular"));
    }

    // Implementacao do metodo da interface ActionListener
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == portugueseItem) {
            loadLanguage(Locale.of("pt", "BR"));
        } else if (source == englishItem) {
            loadLanguage(Locale.US);
        } else if (source == frenchItem) {
            loadLanguage(Locale.FRANCE);
        } else if (source == italianItem) {
            loadLanguage(Locale.ITALY);
        } else if (valueField.getText().length() == 0) {
            JOptionPane.showMessageDialog(
                null,
                bundle.getString("mensagem.valor.nulo"),
                bundle.getString("tela1.erro.titulo"),
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            int n = Integer.parseInt(valueField.getText());
            valueField.setText("" + (n * n));
        }
    }
}
