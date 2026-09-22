import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class WelcomeScreen extends JFrame implements ActionListener {
    private JButton logoutButton = new JButton("Trocar usuario");
    private JButton exitButton = new JButton("Sair");

    public WelcomeScreen(Session session) {
        super("Inicio");
        ImageIcon icon = new ImageIcon(getClass().getResource("/user.png"));
        JPanel details = new JPanel(new GridLayout(0, 1, 5, 5));
        details.setBorder(new EmptyBorder(15, 25, 15, 25));
        details.add(new JLabel(icon, SwingConstants.CENTER));
        details.add(new JLabel("Bem-vindo, " + session.getName() + "!"));
        details.add(new JLabel("Usuario: " + session.getUsername()));
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(session.getLoginTime());
        details.add(new JLabel("Login atual: " + date));

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(logoutButton);
        buttons.add(exitButton);
        logoutButton.addActionListener(this);
        exitButton.addActionListener(this);
        add(details, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setIconImage(icon.getImage());
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == logoutButton) {
            new LoginScreen();
            dispose();
        } else if (event.getSource() == exitButton) {
            dispose();
        }
    }
}
