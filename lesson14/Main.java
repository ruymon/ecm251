import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JFrame implements ActionListener {
    private static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    private final Auth auth;
    private final SimpleDateFormat dateFormat;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;

    public Main() {
        super("ECM251 - Login");

        auth = new Auth();
        dateFormat = new SimpleDateFormat(DATE_TIME_PATTERN);

        ImageIcon lockIcon = new ImageIcon(getClass().getResource("lock.png"));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");
        exitButton = new JButton("Sair");

        JLabel icon = new JLabel(lockIcon, SwingConstants.CENTER);
        icon.setBorder(new EmptyBorder(15, 15, 5, 15));

        JPanel fieldPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        fieldPanel.setBorder(new EmptyBorder(5, 15, 10, 15));
        fieldPanel.add(new JLabel("Nome de usuário:"));
        fieldPanel.add(usernameField);
        fieldPanel.add(new JLabel("Senha:"));
        fieldPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        content.add(icon, BorderLayout.NORTH);
        content.add(fieldPanel, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        getRootPane().setDefaultButton(loginButton);

        setIconImage(lockIcon.getImage());
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == loginButton) {
            login();
        } else if (source == exitButton) {
            System.exit(0);
        }
    }

    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        try {
            Session session = auth.login(username, password);

            if (session == null) {
                JOptionPane.showMessageDialog(this, "Nome de usuário ou senha incorretos.",
                        "Acesso negado", JOptionPane.WARNING_MESSAGE);
                passwordField.setText("");
                passwordField.requestFocus();
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Bem-vindo, " + session.getName() + "!"
                            + "\nNome de usuário: " + session.getUsername()
                            + "\nÚltimo acesso: " + format(session.getLastAccessedAt()),
                    "Acesso permitido", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(this, "Não foi possível acessar o banco de dados.\n" + exception.getMessage(),
                    "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String format(Date moment) {
        if (moment == null) {
            return "primeiro acesso";
        }
        return dateFormat.format(moment);
    }

    public static void main(String[] args) {
        new Main();
    }
}
