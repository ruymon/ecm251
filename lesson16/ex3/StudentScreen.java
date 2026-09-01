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

public class StudentScreen extends JFrame implements ActionListener {
    private static final String[] LABELS = {"RA:", "Name:", "Surname:", "P1:", "P2:", "P3:", "P4:"};

    private CreateStudentFile file;
    private JTextField ra;
    private JTextField name;
    private JTextField surname;
    private JTextField p1;
    private JTextField p2;
    private JTextField p3;
    private JTextField p4;
    private JTextField[] fields;
    private JButton saveButton;
    private JButton clearButton;
    private JButton exitButton;

    public StudentScreen() {
        super("Exercise 3 - Student Registration");

        file = new CreateStudentFile();
        file.openFile();

        ra = new JTextField(15);
        name = new JTextField(15);
        surname = new JTextField(15);
        p1 = new JTextField(15);
        p2 = new JTextField(15);
        p3 = new JTextField(15);
        p4 = new JTextField(15);

        fields = new JTextField[]{ra, name, surname, p1, p2, p3, p4};

        JPanel fieldPanel = new JPanel(new GridLayout(fields.length, 2, 5, 5));
        fieldPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < fields.length; i++) {
            fieldPanel.add(new JLabel(LABELS[i]));
            fieldPanel.add(fields[i]);
        }

        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        content.add(fieldPanel, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);
        getRootPane().setDefaultButton(saveButton);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == saveButton) {
            save();
        } else if (source == clearButton) {
            clear();
        } else if (source == exitButton) {
            file.closeFile();
            System.exit(0);
        }
    }

    private void save() {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try {
            file.addRecord(new Student(
                    ra.getText().trim(),
                    name.getText().trim(),
                    surname.getText().trim(),
                    Double.parseDouble(p1.getText().trim()),
                    Double.parseDouble(p2.getText().trim()),
                    Double.parseDouble(p3.getText().trim()),
                    Double.parseDouble(p4.getText().trim())));
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "The grades must be numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Student saved.");
        clear();
    }

    private void clear() {
        for (JTextField field : fields) {
            field.setText("");
        }

        ra.requestFocus();
    }
}
