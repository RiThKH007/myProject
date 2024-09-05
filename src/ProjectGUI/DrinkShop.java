package ProjectGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DrinkShop extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField subTotalField;
    private JTextField taxField;
    private JTextField totalField;
    private JButton paymentButton = new JButton("Payment");
    private JButton resetButton = new JButton("Reset");
    private JButton printButton = new JButton("Print");
    private JButton removeButton = new JButton("Remove");
    private JButton exitButton = new JButton("Exit");
    private JLabel pic1 = new JLabel();
    private JLabel pic2 = new JLabel();
    private JLabel pic3 = new JLabel();
    private JLabel pic4 = new JLabel();
    private JLabel pic5 = new JLabel();
    private JLabel pic6 = new JLabel();
    private JLabel pic7 = new JLabel();
    private JLabel pic8 = new JLabel();
    private JLabel pic9 = new JLabel();
    private JSpinner qtySpinner1 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JSpinner qtySpinner2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JSpinner qtySpinner3 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JSpinner qtySpinner4 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JSpinner qtySpinner5 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JSpinner qtySpinner6 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JSpinner qtySpinner7 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JSpinner qtySpinner8 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JSpinner qtySpinner9 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private String selection1, selection2, selection3, selection4, selection5, selection6, selection7, selection8, selection9;
    private Connection con;
    private Statement stm;
    private ResultSet rss;

    public DrinkShop() {
        setTitle("Drink Menu");
        setSize(860, 660);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.PINK);

        // Create the title label
        JLabel titleLabel = new JLabel("Drinks Menu");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create table
        String[] columnNames = {"Name", "Qty", "Price","TotalAmount"};
        Object[][] data = {};
        tableModel = new DefaultTableModel(data, columnNames); // add rows to this table later using methods
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(340, 500));
        add(tableScrollPane, BorderLayout.WEST);
        tableScrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        tableScrollPane.setBackground(Color.PINK);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(3, 3));
        imagePanel.setOpaque(false);
        add(imagePanel, BorderLayout.CENTER);
        imagePanel.setBorder(new EmptyBorder(10, 0, 10, 10));

        selection1 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\fanta.jpg";
        ImageIcon icon1 = new ImageIcon(new ImageIcon(selection1).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic1.setIcon(icon1);
        imagePanel.add(createImagePanel(pic1, qtySpinner1));

        selection2 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\sprite.jpg";
        ImageIcon icon2 = new ImageIcon(new ImageIcon(selection2).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic2.setIcon(icon2);
        imagePanel.add(createImagePanel(pic2, qtySpinner2));

        selection3 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\pepsi.jpg";
        ImageIcon icon3 = new ImageIcon(new ImageIcon(selection3).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic3.setIcon(icon3);
        imagePanel.add(createImagePanel(pic3, qtySpinner3));

        selection4 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\fantaapple.jpg";
        ImageIcon icon4 = new ImageIcon(new ImageIcon(selection4).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic4.setIcon(icon4);
        imagePanel.add(createImagePanel(pic4, qtySpinner4));

        selection5 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\coca.jpg";
        ImageIcon icon5 = new ImageIcon(new ImageIcon(selection5).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic5.setIcon(icon5);
        imagePanel.add(createImagePanel(pic5, qtySpinner5));

        selection6 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\sting.jpg";
        ImageIcon icon6 = new ImageIcon(new ImageIcon(selection6).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic6.setIcon(icon6);
        imagePanel.add(createImagePanel(pic6, qtySpinner6));

        selection7 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\cara.jpg";
        ImageIcon icon7 = new ImageIcon(new ImageIcon(selection7).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic7.setIcon(icon7);
        imagePanel.add(createImagePanel(pic7, qtySpinner7));

        selection8 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\ize.jpg";
        ImageIcon icon8 = new ImageIcon(new ImageIcon(selection8).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic8.setIcon(icon8);
        imagePanel.add(createImagePanel(pic8, qtySpinner8));

        selection9 = "C:\\Users\\ADMIN\\OneDrive\\Pictures\\bacc.png";
        ImageIcon icon9 = new ImageIcon(new ImageIcon(selection9).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        pic9.setIcon(icon9);
        imagePanel.add(createImagePanel(pic9, qtySpinner9));

        pic1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addItemToTable("Fanta", (int) qtySpinner1.getValue());
            }
        });

        pic2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addItemToTable("Sprite", (int) qtySpinner2.getValue());
            }
        });

        pic3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addItemToTable("Pepsi", (int) qtySpinner3.getValue());
            }
        });

        pic4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addItemToTable("Fanta apple", (int) qtySpinner4.getValue());
            }
        });

        pic5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addItemToTable("CocaCola", (int) qtySpinner5.getValue());
            }
        });

        pic6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addItemToTable("Sting", (int) qtySpinner6.getValue());
            }
        });

        pic7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addItemToTable("Carabao", (int) qtySpinner7.getValue());
            }
        });

        pic8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addItemToTable("Ize cola", (int) qtySpinner8.getValue());
            }
        });

        pic9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addItemToTable("Bacchus energy", (int) qtySpinner9.getValue());
            }
        });

        // Create the left bottom panel
        JPanel leftBottomPanel = new JPanel();
        leftBottomPanel.setLayout(new GridLayout(3, 2));
        leftBottomPanel.setBackground(Color.PINK);

        leftBottomPanel.add(new JLabel("Sub Total:"));
        subTotalField = new JTextField("0.00");
        subTotalField.setEditable(false);
        leftBottomPanel.add(subTotalField);

        leftBottomPanel.add(new JLabel("Tax:"));
        taxField = new JTextField("0.00");
        taxField.setEditable(false);
        leftBottomPanel.add(taxField);

        leftBottomPanel.add(new JLabel("Total:"));
        totalField = new JTextField("0.00");
        totalField.setEditable(false);
        leftBottomPanel.add(totalField);

        // Create the right bottom panel
        JPanel rightBottomPanel = new JPanel();
        rightBottomPanel.setLayout(new GridLayout(1, 5));
        rightBottomPanel.setOpaque(true);
        rightBottomPanel.add(paymentButton);
        rightBottomPanel.add(resetButton);
        rightBottomPanel.add(printButton);
        rightBottomPanel.add(removeButton);
        rightBottomPanel.add(exitButton);
        paymentButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setBackground(Color.GRAY);
        printButton.setBackground(Color.BLUE);
        removeButton.setBackground(Color.RED);
        exitButton.setBackground(Color.magenta);
        rightBottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        rightBottomPanel.setBackground(Color.PINK);

        // Create the bottom container panel
        JPanel bottomContainerPanel = new JPanel(new BorderLayout());
        bottomContainerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        bottomContainerPanel.setBackground(Color.PINK);
        bottomContainerPanel.add(leftBottomPanel, BorderLayout.WEST);
        bottomContainerPanel.add(rightBottomPanel, BorderLayout.EAST);
        add(bottomContainerPanel, BorderLayout.SOUTH);

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle payment action
                JOptionPane.showMessageDialog(null, "Payment processed.");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle reset action
                resetTable();
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayReceipt();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedRow();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Database Connection
        connectToDatabase();
        loadData();
    }
    private void connectToDatabase() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3310/dbjava", "root", "");
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void loadData() {
        try {
            String query = "SELECT * FROM tbdrinkshop;";
            rss = stm.executeQuery(query);
            while (rss.next()) {
//                int id = rss.getInt("id");
                String itemName = rss.getString("itemName");
                int qty = rss.getInt("qty");
                double price = rss.getDouble("price");
                double amount = price*qty;
//                float Tamount = rss.getFloat("amount");
                tableModel.addRow(new Object[]{itemName, qty, price,amount});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private JPanel createImagePanel(JLabel label, JSpinner spinner) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(label, BorderLayout.CENTER);
        panel.add(spinner, BorderLayout.SOUTH);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        return panel;
    }
    private void addItemToTable(String itemName, int qty) {
        double price = 0.5; // Assume price is $0.5, you can adjust this or fetch from DB if needed
        double amount = price * qty;
        // Add to the table
        tableModel.addRow(new Object[]{itemName, qty, price, amount});
        updateTotals();
        // Store in the database
        try {
            String query = "INSERT INTO tbdrinkshop (itemName, qty, price, amount) VALUES ('" + itemName + "', " + qty + ", " + price + ", " + amount + ")";
            stm.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void resetTable() {
        // Clear the table
        tableModel.setRowCount(0);
        updateTotals();
    }
    private void removeSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String itemName = (String) tableModel.getValueAt(selectedRow, 0);
            tableModel.removeRow(selectedRow);
            // Update the totals
            updateTotals();
            try {
                String query = "DELETE FROM tbdrinkshop WHERE itemName = '" + itemName + "'";
                stm.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTotals() {
        // Update the subtotal, tax, and total fields
        double subtotal = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            subtotal += (double) tableModel.getValueAt(i, 3);//row i& colum 2
        }
        double tax = subtotal * 0.03;
        double total = subtotal + tax;
        subTotalField.setText(String.format("%.2f", subtotal));
        taxField.setText(String.format("%.2f", tax));
        totalField.setText(String.format("%.2f", total));
    }

    private void displayReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("***** Receipt *****\n");
        receipt.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("\n\n");
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String itemName = tableModel.getValueAt(i, 0).toString();
            String quantity = tableModel.getValueAt(i, 1).toString();
            String price = tableModel.getValueAt(i, 2).toString();
            receipt.append(itemName).append(" x ").append(quantity).append(" = $").append(price).append("\n");
        }
        receipt.append("\nSubtotal: $").append(subTotalField.getText()).append("\n");
        receipt.append("Tax : $").append(taxField.getText()).append("\n");
        receipt.append("Total: $").append(totalField.getText()).append("\n");
        JOptionPane.showMessageDialog(null, receipt.toString(), "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        DrinkShop frame = new DrinkShop();
        frame.setVisible(true);
    }
}
