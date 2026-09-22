import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ExampleScreen extends JFrame implements ActionListener {
    private JTextField nameField;
    private JButton showButton;
    private JButton clearButton;

    public ExampleScreen() {
        super("Meu programa");
        nameField = new JTextField(20);
        showButton = new JButton("Mostrar");
        clearButton = new JButton("Limpar");

        getContentPane().setLayout(new FlowLayout());
        add(new JLabel("Nome:"));
        add(nameField);
        add(showButton);
        add(clearButton);
        showButton.addActionListener(this);
        clearButton.addActionListener(this);
        getRootPane().setDefaultButton(showButton);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == showButton) {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o nome.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Ola, " + name + "!");
        } else if (event.getSource() == clearButton) {
            nameField.setText("");
            nameField.requestFocusInWindow();
        }
    }
}
