import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginScreen extends JFrame implements ActionListener {
    private final Auth auth;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton exitButton;
    private JMenu languageMenu;
    private JMenuItem portugueseItem;
    private JMenuItem englishItem;
    private Locale locale;
    private ResourceBundle bundle;

    public LoginScreen() {
        auth = new Auth();

        ImageIcon lockIcon = new ImageIcon(getClass().getResource("lock.png"));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        passwordField.setEchoChar('*');

        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        loginButton = new JButton();
        exitButton = new JButton();

        JLabel picture = new JLabel(lockIcon, SwingConstants.CENTER);
        picture.setBorder(new EmptyBorder(15, 15, 5, 15));

        JPanel fieldPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        fieldPanel.setBorder(new EmptyBorder(5, 15, 10, 15));
        fieldPanel.add(usernameLabel);
        fieldPanel.add(usernameField);
        fieldPanel.add(passwordLabel);
        fieldPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        content.add(picture, BorderLayout.NORTH);
        content.add(fieldPanel, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);

        // Cada item do menu carrega um dos idiomas suportados
        portugueseItem = new JMenuItem("Português");
        englishItem = new JMenuItem("English");

        languageMenu = new JMenu();
        languageMenu.add(portugueseItem);
        languageMenu.add(englishItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(languageMenu);
        setJMenuBar(menuBar);

        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        portugueseItem.addActionListener(this);
        englishItem.addActionListener(this);
        getRootPane().setDefaultButton(loginButton);

        // Idioma inicial da aplicação
        loadLanguage(Locale.of("pt", "BR"));

        setIconImage(lockIcon.getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Carga do arquivo de internacionalização e atualização dos textos da tela
    private void loadLanguage(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle("Ex2", locale);
        setTitle(bundle.getString("login.title"));
        languageMenu.setText(bundle.getString("menu.language"));
        usernameLabel.setText(bundle.getString("login.label.username") + ":");
        passwordLabel.setText(bundle.getString("login.label.password") + ":");
        loginButton.setText(bundle.getString("login.button.login"));
        exitButton.setText(bundle.getString("login.button.exit"));
        pack();
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == loginButton) {
            login();
        } else if (source == exitButton) {
            System.exit(0);
        } else if (source == portugueseItem) {
            loadLanguage(Locale.of("pt", "BR"));
        } else if (source == englishItem) {
            loadLanguage(Locale.US);
        }
    }

    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        try {
            Session session = auth.login(username, password);

            if (session == null) {
                JOptionPane.showMessageDialog(this, bundle.getString("login.error.credentials.message"),
                        bundle.getString("login.error.credentials.title"), JOptionPane.WARNING_MESSAGE);
                passwordField.setText("");
                passwordField.requestFocus();
                return;
            }

            dispose();
            // O idioma escolhido antes do login segue para a proxima tela
            new OverviewScreen(session, locale);
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(this,
                    bundle.getString("login.error.database.message") + "\n" + exception.getMessage(),
                    bundle.getString("login.error.database.title"), JOptionPane.ERROR_MESSAGE);
        }
    }
}
