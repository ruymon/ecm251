import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LanguageScreen extends JFrame implements ActionListener {
    private JLabel nameLabel = new JLabel();
    private JLabel dateLabel = new JLabel();
    private JLabel numberLabel = new JLabel();
    private JTextField nameField = new JTextField(18);
    private JButton greetButton = new JButton();
    private JMenu languageMenu = new JMenu();
    private JMenuItem portugueseItem = new JMenuItem("Portugues");
    private JMenuItem englishItem = new JMenuItem("English");
    private Locale locale;
    private ResourceBundle bundle;

    public LanguageScreen() {
        JPanel input = new JPanel(new FlowLayout());
        input.add(nameLabel);
        input.add(nameField);
        input.add(greetButton);
        JPanel examples = new JPanel(new GridLayout(0, 1, 5, 5));
        examples.setBorder(new EmptyBorder(10, 10, 10, 10));
        examples.add(dateLabel);
        examples.add(numberLabel);
        add(input, BorderLayout.NORTH);
        add(examples, BorderLayout.CENTER);

        languageMenu.add(portugueseItem);
        languageMenu.add(englishItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(languageMenu);
        setJMenuBar(menuBar);
        greetButton.addActionListener(this);
        portugueseItem.addActionListener(this);
        englishItem.addActionListener(this);
        getRootPane().setDefaultButton(greetButton);

        loadLanguage(new Locale("pt", "BR"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadLanguage(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle("Messages", locale);
        setTitle(bundle.getString("screen.title"));
        languageMenu.setText(bundle.getString("menu.language"));
        nameLabel.setText(bundle.getString("label.name"));
        greetButton.setText(bundle.getString("button.greet"));
        String date = DateFormat.getDateInstance(DateFormat.SHORT, locale).format(new Date());
        String number = NumberFormat.getNumberInstance(locale).format(1234.5);
        dateLabel.setText(bundle.getString("label.date") + " " + date);
        numberLabel.setText(bundle.getString("label.number") + " " + number);
        pack();
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == portugueseItem) {
            loadLanguage(new Locale("pt", "BR"));
        } else if (event.getSource() == englishItem) {
            loadLanguage(Locale.US);
        } else if (event.getSource() == greetButton) {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, bundle.getString("error.name"),
                        bundle.getString("error.title"), JOptionPane.WARNING_MESSAGE);
                return;
            }
            MessageFormat format = new MessageFormat(bundle.getString("message.hello"), locale);
            JOptionPane.showMessageDialog(this, format.format(new Object[] {name}),
                    bundle.getString("screen.title"), JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
