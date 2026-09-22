import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class StudentScreen extends JFrame implements ActionListener, ListSelectionListener {
    private ArrayList<Student> students = new ArrayList<Student>();
    private JTextField raField = new JTextField(15);
    private JTextField nameField = new JTextField(20);
    private JComboBox<String> courseBox = new JComboBox<String>(new String[] {
        "Engenharia", "Administracao", "Computacao"
    });
    private JTextField gradeField = new JTextField(10);
    private JTextField dateField = new JTextField(10);
    private JButton addButton = new JButton("Adicionar");
    private JButton updateButton = new JButton("Atualizar selecionado");
    private JButton removeButton = new JButton("Excluir selecionado");
    private JButton clearButton = new JButton("Limpar");
    private JMenuItem searchItem = new JMenuItem("Buscar por RA");
    private JMenuItem saveItem = new JMenuItem("Salvar arquivo...");
    private JMenuItem openItem = new JMenuItem("Abrir arquivo...");
    private JMenuItem exitItem = new JMenuItem("Sair");
    private JMenuItem aboutItem = new JMenuItem("Sobre");
    private DefaultTableModel model;
    private JTable table;

    public StudentScreen() {
        super("Cadastro de alunos");
        JPanel fields = new JPanel(new GridLayout(0, 2, 5, 5));
        fields.setBorder(new EmptyBorder(10, 10, 10, 10));
        fields.add(new JLabel("RA:"));
        fields.add(raField);
        fields.add(new JLabel("Nome:"));
        fields.add(nameField);
        fields.add(new JLabel("Curso:"));
        fields.add(courseBox);
        fields.add(new JLabel("Nota (0 a 10):"));
        fields.add(gradeField);
        fields.add(new JLabel("Matricula (dd/MM/aaaa):"));
        fields.add(dateField);

        model = new DefaultTableModel(new String[] {"RA", "Nome", "Curso", "Nota", "Data"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false; // Edit through the form, keeping the list and table in sync.
            }
        };
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(this);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(680, 200));

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(addButton);
        buttons.add(updateButton);
        buttons.add(removeButton);
        buttons.add(clearButton);
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        removeButton.addActionListener(this);
        clearButton.addActionListener(this);

        JMenu fileMenu = new JMenu("Arquivo");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(searchItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        JMenu helpMenu = new JMenu("Ajuda");
        helpMenu.add(aboutItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
        searchItem.addActionListener(this);
        saveItem.addActionListener(this);
        openItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);

        getContentPane().setLayout(new BorderLayout());
        add(fields, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        clearFields();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == addButton) {
            saveStudent(false);
        } else if (source == updateButton) {
            saveStudent(true);
        } else if (source == removeButton) {
            removeStudent();
        } else if (source == clearButton) {
            clearFields();
        } else if (source == searchItem) {
            searchStudent();
        } else if (source == saveItem) {
            saveFile();
        } else if (source == openItem) {
            openFile();
        } else if (source == aboutItem) {
            JOptionPane.showMessageDialog(this, "Cadastro com JTable e JComboBox.",
                    "Sobre", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == exitItem) {
            dispose();
        }
    }

    private void saveStudent(boolean update) {
        int row = selectedRow();
        if (update && row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para atualizar.");
            return;
        }
        try {
            double grade = Double.parseDouble(gradeField.getText().trim().replace(',', '.'));
            Student student = new Student(raField.getText(), nameField.getText(),
                    (String) courseBox.getSelectedItem(), grade, DateHelper.parse(dateField.getText()));
            for (int i = 0; i < students.size(); i++) {
                if ((!update || i != row) && students.get(i).getRa().equals(student.getRa())) {
                    throw new IllegalArgumentException("Ja existe um aluno com este RA.");
                }
            }
            if (update) {
                students.set(row, student);
            } else {
                students.add(student);
            }
            refreshTable();
            clearFields();
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Digite uma nota numerica, como 7,5.");
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Dados invalidos",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void removeStudent() {
        int row = selectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir.");
            return;
        }
        int answer = JOptionPane.showConfirmDialog(this, "Excluir o aluno selecionado?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            students.remove(row);
            refreshTable();
            clearFields();
        }
    }

    private void searchStudent() {
        String ra = JOptionPane.showInputDialog(this, "RA do aluno:");
        if (ra == null) {
            return; // Cancel was clicked.
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRa().equals(ra.trim())) {
                int viewRow = table.convertRowIndexToView(i);
                table.setRowSelectionInterval(viewRow, viewRow);
                table.scrollRectToVisible(table.getCellRect(viewRow, 0, true));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Aluno nao encontrado.");
    }

    private void saveFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("students.txt"));
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        if (file.exists() && JOptionPane.showConfirmDialog(this, "Substituir o arquivo existente?",
                "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            StudentTextFile.save(file.getAbsolutePath(), students);
            JOptionPane.showMessageDialog(this, "Arquivo salvo.");
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Erro ao salvar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        if (!students.isEmpty() && JOptionPane.showConfirmDialog(this, "Substituir a lista atual?",
                "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            // Read first: a missing or invalid file must not erase the current list.
            ArrayList<Student> loaded = new ArrayList<Student>(
                    StudentTextFile.load(chooser.getSelectedFile().getAbsolutePath()));
            table.clearSelection();
            students = loaded;
            refreshTable();
            clearFields();
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Erro ao abrir",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void valueChanged(ListSelectionEvent event) {
        int row = selectedRow();
        if (event.getValueIsAdjusting() || row == -1) {
            return;
        }
        Student student = students.get(row);
        raField.setText(student.getRa());
        nameField.setText(student.getName());
        courseBox.setSelectedItem(student.getCourse());
        gradeField.setText(String.valueOf(student.getGrade()));
        dateField.setText(DateHelper.format(student.getEnrollmentDate()));
    }

    private int selectedRow() {
        int row = table.getSelectedRow();
        return row == -1 ? -1 : table.convertRowIndexToModel(row);
    }

    private void refreshTable() {
        table.clearSelection();
        model.setRowCount(0);
        for (Student student : students) {
            model.addRow(new Object[] {student.getRa(), student.getName(), student.getCourse(),
                student.getGrade(), DateHelper.format(student.getEnrollmentDate())});
        }
    }

    private void clearFields() {
        table.clearSelection();
        raField.setText("");
        nameField.setText("");
        courseBox.setSelectedIndex(0);
        gradeField.setText("");
        dateField.setText(DateHelper.format(new Date()));
        raField.requestFocusInWindow();
    }
}
