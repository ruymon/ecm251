import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SearchScreen extends JFrame implements ActionListener {
    private JTextField ra;
    private JButton searchButton;
    private JButton clearButton;
    private JButton exitButton;

    public SearchScreen() {
        super("Exercise 4 - Student Search");

        ra = new JTextField(15);

        JPanel fieldPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        fieldPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        fieldPanel.add(new JLabel("RA:"));
        fieldPanel.add(ra);

        searchButton = new JButton("Search");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(searchButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        content.add(fieldPanel, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);
        getRootPane().setDefaultButton(searchButton);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == searchButton) {
            search();
        } else if (source == clearButton) {
            ra.setText("");
            ra.requestFocus();
        } else if (source == exitButton) {
            System.exit(0);
        }
    }

    private void search() {
        String value = ra.getText().trim();

        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter an RA.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ReadStudentFile file = new ReadStudentFile();

        try {
            file.openFile();
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(this, "Error opening file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = file.findStudent(value);
        file.closeFile();

        if (student == null) {
            JOptionPane.showMessageDialog(this, "RA NOT REGISTERED", "Search", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, String.format("RA: %s%nName: %s%nSurname: %s%nAverage: %.2f",
                    student.getRa(), student.getName(), student.getSurname(), student.getAverage()),
                    "Search", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
