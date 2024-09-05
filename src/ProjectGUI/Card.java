package ProjectGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Card extends JFrame implements ActionListener {
    private JLabel l1 = new JLabel("Student Name");
    private JComboBox<String> name = new JComboBox<>();
    private JButton btns = new JButton("Show");
    private JButton btne = new JButton("Exit");

    private JLabel pictureLabel = new JLabel();
    private JLabel studentIdLabel = new JLabel("StudentID:");
    private JLabel studentNameLabel = new JLabel("Student Name:");
    private JLabel sexLabel = new JLabel("Sex:");
    private JLabel dobLabel = new JLabel("DOB:");
    private JLabel majorLabel = new JLabel("Major:");

    public Card() {
        setLayout(null);

        // Title Panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.cyan);
        JLabel titleLabel = new JLabel("Student Card", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.setBounds(0, 0, 600, 40);
        add(titlePanel);

        // Name ComboBox and Buttons
        l1.setBounds(30, 60, 100, 20);
        add(l1);

        name.setBounds(130, 60, 150, 20);
        name.addItem("Ngorn Lika");
        name.addItem("Keo Sovannarith");
        name.addItem("Raksa Chamrong");
        name.addItem("Kun Seyha");
        name.addItem("Chon Panha");
        name.addItem("Ngo CheckTay");
        name.addItem("Chhay Seyhak");
        add(name);

        btns.setBounds(330, 60, 80, 20);
        btns.setBackground(Color.GREEN);
        btns.addActionListener(this);
        add(btns);

        btne.setBounds(420, 60, 80, 20);
        btne.setBackground(Color.RED);
        btne.addActionListener(this);
        add(btne);

        // Picture and Labels Panel
        JPanel infoPanel = new JPanel(null);
        infoPanel.setBounds(0, 100, 600, 200);
        infoPanel.setBackground(new Color(208, 236, 240)); // Light cyan color
        add(infoPanel);

        pictureLabel.setBounds(50, 10, 200, 180); // Increased size
        infoPanel.add(pictureLabel);

        studentIdLabel.setBounds(230, 10, 300, 20);
        infoPanel.add(studentIdLabel);

        studentNameLabel.setBounds(230, 40, 300, 20);
        infoPanel.add(studentNameLabel);

        sexLabel.setBounds(230, 70, 300, 20);
        infoPanel.add(sexLabel);

        dobLabel.setBounds(230, 100, 300, 20);
        infoPanel.add(dobLabel);

        majorLabel.setBounds(230, 130, 300, 20);
        infoPanel.add(majorLabel);

        // Window Properties
        setTitle("Student Information");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Card();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btns) {
            String selectedName = (String) name.getSelectedItem();
            Object[] studentInfo = null;
            String selection = null;
            if ("Ngorn Lika".equals(selectedName)) {
                selection = "C:\\Users\\ASUS\\OneDrive\\Pictures\\d4.png";
                studentInfo = new Object[]{"ID02", "Ngorn Lika", "Female", "12/09/2004", "Computer Science"};
            }
            if ("Keo Sovannarith".equals(selectedName)) {
                selection = "C:\\Users\\ASUS\\OneDrive\\Pictures\\d1.jpg";
                studentInfo = new Object[]{"ID01", "Keo Sovannarith", "Male", "12/12/2004", "Computer Science"};
            }
            if ("Ngo CheckTay".equals(selectedName)) {
                selection = "C:\\Users\\ASUS\\OneDrive\\Pictures\\d2.png";
                studentInfo = new Object[]{"ID03", "Ngo CheckTay", "Male", "01/07/2004", "Computer Science"};
            }
            if ("Raksa Chamrong".equals(selectedName)) {
                selection = "C:\\Users\\ASUS\\OneDrive\\Pictures\\d3.png";
                studentInfo = new Object[]{"ID05", "Raksa Chamrong", "Male", "01/08/2004", "Computer Science"};
            }
            if ("Kun Seyha".equals(selectedName)) {
                selection = "C:\\Users\\ASUS\\OneDrive\\Pictures\\d5.png";
                studentInfo = new Object[]{"ID04", "Kun Seyha", "Male", "01/08/2004", "Computer Science"};
            }
            if ("Chon Panha".equals(selectedName)) {
                selection = "C:\\Users\\ASUS\\OneDrive\\Pictures\\d6.jpg";
                studentInfo = new Object[]{"ID06", "Chon Panha", "Male", "01/08/2004", "Computer Science"};
            }
            if ("Chhay Seyhak".equals(selectedName)) {
                selection = "C:\\Users\\ASUS\\OneDrive\\Pictures\\d7.png";
                studentInfo = new Object[]{"ID07", "Chhay Seyhak", "Male", "01/08/2004", "Computer Science"};
            }
            if (studentInfo != null) {
                pictureLabel.setIcon(new ImageIcon(new ImageIcon(selection).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH))); // Increased size
                studentIdLabel.setText("StudentID: " + studentInfo[0]);
                studentNameLabel.setText("Student Name: " + studentInfo[1]);
                sexLabel.setText("Sex: " + studentInfo[2]);
                dobLabel.setText("DOB: " + studentInfo[3]);
                majorLabel.setText("Major: " + studentInfo[4]);
            }
        }
        if (ae.getSource() == btne) {
            System.exit(0);
        }
    }
}

