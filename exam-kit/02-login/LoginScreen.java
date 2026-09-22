import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginScreen extends JFrame implements ActionListener {
    private Auth auth = new Auth();
    private JTextField usernameField = new JTextField(18);
    private JPasswordField passwordField = new JPasswordField(18);
    private JCheckBox showPasswordBox = new JCheckBox("Mostrar senha");
    private JButton loginButton = new JButton("Entrar");
    private JButton clearButton = new JButton("Limpar");
    private JButton exitButton = new JButton("Sair");

    public LoginScreen() {
        super("Login");
        passwordField.setEchoChar('*');
        ImageIcon icon = new ImageIcon(getClass().getResource("/lock.png"));
        JLabel picture = new JLabel(icon, SwingConstants.CENTER);
        picture.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel fields = new JPanel(new GridLayout(0, 2, 5, 5));
        fields.setBorder(new EmptyBorder(10, 10, 10, 10));
        fields.add(new JLabel("Usuario:"));
        fields.add(usernameField);
        fields.add(new JLabel("Senha:"));
        fields.add(passwordField);
        fields.add(new JLabel("Conta de exemplo: admin / 1234"));
        fields.add(showPasswordBox);

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(loginButton);
        buttons.add(clearButton);
        buttons.add(exitButton);
        loginButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);
        showPasswordBox.addActionListener(this);
        getRootPane().setDefaultButton(loginButton);

        getContentPane().setLayout(new BorderLayout());
        add(picture, BorderLayout.NORTH);
        add(fields, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setIconImage(icon.getImage());
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == loginButton) {
            login();
        } else if (source == clearButton) {
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocusInWindow();
        } else if (source == showPasswordBox) {
            passwordField.setEchoChar(showPasswordBox.isSelected() ? (char) 0 : '*');
        } else if (source == exitButton) {
            dispose();
        }
    }

    private void login() {
        String username = usernameField.getText().trim();
        char[] password = passwordField.getPassword();
        try {
            if (username.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(this, "Preencha usuario e senha.");
                return;
            }
            Session session = auth.login(username, password);
            if (session == null) {
                JOptionPane.showMessageDialog(this, "Usuario ou senha incorretos.",
                        "Acesso negado", JOptionPane.WARNING_MESSAGE);
                passwordField.requestFocusInWindow();
                return;
            }
            new WelcomeScreen(session); // Replace with your application's next screen.
            dispose();
        } finally {
            Arrays.fill(password, '\0');
            passwordField.setText("");
        }
    }
}
