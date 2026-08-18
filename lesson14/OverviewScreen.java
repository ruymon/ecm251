import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OverviewScreen extends JFrame implements ActionListener {
    private static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";
    private static final String[] COLUMN_NAMES = {"Grade", "Absences"};
    private static final Dimension TABLE_SIZE = new Dimension(320, 40);

    private final SimpleDateFormat dateFormat;
    private JButton exitButton;

    public OverviewScreen(Session session) {
        super("ECM251 - Visão do Aluno");

        dateFormat = new SimpleDateFormat(DATE_TIME_PATTERN);

        ImageIcon userIcon = new ImageIcon(getClass().getResource("user.png"));

        JLabel picture = new JLabel(userIcon, SwingConstants.CENTER);
        picture.setBorder(new EmptyBorder(15, 15, 5, 15));

        JLabel greeting = new JLabel("Welcome, " + session.getName(), SwingConstants.CENTER);
        greeting.setFont(greeting.getFont().deriveFont(Font.BOLD, 16f));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(picture, BorderLayout.CENTER);
        headerPanel.add(greeting, BorderLayout.SOUTH);

        JPanel detailPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        detailPanel.setBorder(new EmptyBorder(10, 15, 10, 15));
        detailPanel.add(new JLabel("Nome de usuário:"));
        detailPanel.add(new JLabel(session.getUsername()));
        detailPanel.add(new JLabel("Último acesso:"));
        detailPanel.add(new JLabel(formatPreviousAccess(session.getLastAccessedAt())));

        JTable table = new JTable(buildTableModel(session));
        table.setEnabled(false);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(TABLE_SIZE);

        JPanel tablePanel = new JPanel(new BorderLayout(0, 5));
        tablePanel.setBorder(new EmptyBorder(0, 15, 10, 15));
        tablePanel.add(new JLabel("Nota e faltas"), BorderLayout.NORTH);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(headerPanel, BorderLayout.NORTH);
        topPanel.add(detailPanel, BorderLayout.SOUTH);

        exitButton = new JButton("Sair");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(exitButton);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        content.add(topPanel, BorderLayout.NORTH);
        content.add(tablePanel, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);

        exitButton.addActionListener(this);

        setIconImage(userIcon.getImage());
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private DefaultTableModel buildTableModel(Session session) {
        Object[][] rows = {{String.format("%.1f", session.getGrade()), session.getAbsences()}};
        return new DefaultTableModel(rows, COLUMN_NAMES);
    }

    private String formatPreviousAccess(Date moment) {
        if (moment == null) {
            return "primeiro acesso";
        }
        return dateFormat.format(moment);
    }
}
