package ProjectGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Infomation extends JFrame implements ActionListener {
    private JLabel l1 = new JLabel("Student Name");
    private JComboBox<String> name = new JComboBox<>();
    private JButton btns = new JButton("Show");
    private JLabel answer1 = new JLabel();
    private JLabel titleLabel, nameLabel,majorLabel, deptLabel, emailLabel, phoneLabel, idLabel;
    private RoundedPanel studentCard;
    private String selection;

    public Infomation() {
        // Create a panel for the title
        JPanel titlePanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("A2Y2 Group 1", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.setBackground(new Color(0, 51, 102));
        titlePanel.setBounds(0, 0, 500, 40);
        titlePanel.add(titleLabel);
        add(titlePanel);

        // Set layout and background color for the frame
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        l1.setBounds(50, 60, 100, 20);
        add(l1);

        name.setBounds(150, 60, 150, 20);
        name.setBackground(Color.blue);
        name.addItem("Ngorn Lika");
        name.addItem("Kun Seyha");
        name.addItem("Keo Sovannarith");
        name.addItem("Chhay Seyhak");
        add(name);

        btns.setBounds(340, 60, 80, 20);
        btns.addActionListener(this);
        add(btns);
        btns.setBackground(Color.BLUE);

        // Create a RoundedPanel for the student card
        studentCard = new RoundedPanel(10, new Color(0, 51, 102), Color.BLACK);
        studentCard.setLayout(null);
        studentCard.setBounds(130, 120, 235, 380);
        studentCard.setVisible(false); // Initially hidden
        add(studentCard);

        // Configure and add answer1 to studentCard (for the photo)
        answer1.setBounds(30, 30, 170, 170);
        studentCard.add(answer1);

        // Student's name label
        nameLabel = new JLabel("", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(new Color(102, 204, 255));
        nameLabel.setBounds(30, 220, 170, 20);
        studentCard.add(nameLabel);

        // Department label
        deptLabel = new JLabel("", SwingConstants.CENTER);
        deptLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        deptLabel.setForeground(Color.WHITE);
        deptLabel.setBounds(30, 250, 170, 20);
        studentCard.add(deptLabel);

        majorLabel = new JLabel("", SwingConstants.CENTER);
        majorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        majorLabel.setForeground(Color.WHITE);
        majorLabel.setBounds(30, 270, 170, 20);
        studentCard.add(majorLabel);
        // Email label
        emailLabel = new JLabel("", SwingConstants.CENTER);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(30, 290, 170, 20);
        studentCard.add(emailLabel);

        // Phone label
        phoneLabel = new JLabel("", SwingConstants.CENTER);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setBounds(30, 310, 170, 20);
        studentCard.add(phoneLabel);

        // ID label
        idLabel = new JLabel("", SwingConstants.CENTER);
        idLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(30, 330, 170, 20);
        studentCard.add(idLabel);

        setTitle("Student Info");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Infomation();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btns) {
            studentCard.setVisible(true); // Show the student card when "Show" button is clicked

            String selectedName = (String) name.getSelectedItem();

            // Update the student card based on the selected name
            if ("Kun Seyha".equals(selectedName)) {
                nameLabel.setText("Kun Seyha");
                deptLabel.setText("Dept: Information Technology");
                majorLabel.setText("Major: Computer Science");
                emailLabel.setText("Email: Seyha@school.edu");
                phoneLabel.setText("Phone: +855 12345678");
                idLabel.setText("ID: 001");

                selection = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\done.jpg";
                ImageIcon icon = new ImageIcon(new ImageIcon(selection).getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH));
                answer1.setIcon(icon);

            } else if ("Ngorn Lika".equals(selectedName)) {
                nameLabel.setText("Ngorn Lika");
                deptLabel.setText("Dept: Information Technology");
                majorLabel.setText("Major: Computer Science");
                emailLabel.setText("Email: lika@school.edu");
                phoneLabel.setText("Phone: +855 87654321");
                idLabel.setText("ID: 002");

                selection = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\pex.jpg";
                ImageIcon icon = new ImageIcon(new ImageIcon(selection).getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH));
                answer1.setIcon(icon);

            } else if ("Keo Sovannarith".equals(selectedName)) {
                nameLabel.setText("Keo Sovannarith");
                deptLabel.setText("Dept: Information Technology");
                majorLabel.setText("Major: Computer Science");
                emailLabel.setText("Email: Sovannarith@school.edu");
                phoneLabel.setText("Phone: +855 11223344");
                idLabel.setText("ID: 003");

                selection = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\uii.jpg";
                ImageIcon icon = new ImageIcon(new ImageIcon(selection).getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH));
                answer1.setIcon(icon);
            }
            else if ("Chhay Seyhak".equals(selectedName)) {
                nameLabel.setText("Chhay Seyhak");
                deptLabel.setText("Dept: Information Technology");
                majorLabel.setText("Major: Computer Science");
                emailLabel.setText("Email: ChhaySeyhak@school.edu");
                phoneLabel.setText("Phone: +855 11223344");
                idLabel.setText("ID: 004");

                selection = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\uii.jpg";
                ImageIcon icon = new ImageIcon(new ImageIcon(selection).getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH));
                answer1.setIcon(icon);
            }
        }
    }
}

// Custom JPanel class for rounded corners and shadow
class RoundedPanel extends JPanel {
    private int cornerRadius;
    private Color backgroundColor;
    private Color shadowColor;

    public RoundedPanel(int cornerRadius, Color bgColor, Color shadowColor) {
        super();
        this.cornerRadius = cornerRadius;
        this.backgroundColor = bgColor;
        this.shadowColor = shadowColor;
        setOpaque(false); // Make the panel non-opaque to allow custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow
        g2.setColor(shadowColor);
        g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, cornerRadius, cornerRadius);

        // Draw rounded rectangle
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 10, cornerRadius, cornerRadius);
    }
}

