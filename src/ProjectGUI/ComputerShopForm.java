package ProjectGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class ComputerShopForm extends JFrame {

    // Components of the Form
    private JTextField modelIDField, nameField, priceField, dateField;
    private JButton addButton, updateButton, deleteButton, showButton;
    private JTable table;
    private DefaultTableModel tableModel;

    // Database connection object
    private Connection connection;

    // Constructor to set up the GUI components
    public ComputerShopForm() {
        // Initialize database connection
        initializeDBConnection();

        // Set title and default close operation
        setTitle("Computer Shop Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(44, 62, 80)); // Dark blue-grey background

        // Create form panel with rounded borders
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10)); // Updated to 6 rows for extra buttons
        formPanel.setBackground(new Color(52, 73, 94)); // Slightly lighter shade
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        formPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Rounded borders

        // Add components to the form panel
        JLabel modelIDLabel = new JLabel("Model ID:");
        modelIDLabel.setForeground(Color.WHITE);
        formPanel.add(modelIDLabel);
        modelIDField = new JTextField();
        modelIDField.setBackground(new Color(236, 240, 241)); // Light grey for text field
        formPanel.add(modelIDField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        formPanel.add(nameLabel);
        nameField = new JTextField();
        nameField.setBackground(new Color(236, 240, 241));
        formPanel.add(nameField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setForeground(Color.WHITE);
        formPanel.add(priceLabel);
        priceField = new JTextField();
        priceField.setBackground(new Color(236, 240, 241));
        formPanel.add(priceField);

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setForeground(Color.WHITE);
        formPanel.add(dateLabel);
        dateField = new JTextField();
        dateField.setBackground(new Color(236, 240, 241));
        formPanel.add(dateField);

        // Create Add button
        addButton = new JButton("Add");
        configureButton(addButton, new Color(39, 174, 96), new Color(34, 153, 84));
        formPanel.add(addButton);

        // Create Update button
        updateButton = new JButton("Update");
        configureButton(updateButton, new Color(241, 196, 15), new Color(243, 156, 18));
        formPanel.add(updateButton);

        // Create Delete button
        deleteButton = new JButton("Delete");
        configureButton(deleteButton, new Color(231, 76, 60), new Color(192, 57, 43));
        formPanel.add(deleteButton);

        // Create Show button
        showButton = new JButton("Show");
        configureButton(showButton, new Color(255, 182, 193), new Color(255, 105, 180));
        formPanel.add(showButton);

        // Create table model and table
        tableModel = new DefaultTableModel(new String[]{"Model ID", "Name", "Price", "Date"}, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setBackground(new Color(44, 62, 80)); // Match background color for table
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setGridColor(new Color(189, 195, 199)); // Light grey grid lines
        table.setBorder(new LineBorder(new Color(189, 195, 199), 1));

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(new Color(52, 152, 219)); // Bright blue header
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setReorderingAllowed(false); // Disable column reordering
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 35));

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add form panel and table to the frame
        add(formPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);

        // Add button action listener to add data to the table
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelID = modelIDField.getText();
                String name = nameField.getText();
                String price = priceField.getText();
                String date = dateField.getText();

                try {
                    String query = "INSERT INTO computer_shop (modelID, name, price, date) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, modelID);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, price);
                    preparedStatement.setString(4, date);

                    preparedStatement.executeUpdate();

                    // Add data to the table model
                    tableModel.addRow(new Object[]{modelID, name, price, date});

                    // Clear the input fields
                    modelIDField.setText("");
                    nameField.setText("");
                    priceField.setText("");
                    dateField.setText("");

                    JOptionPane.showMessageDialog(ComputerShopForm.this, "Record added successfully!");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ComputerShopForm.this, "Error adding record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Show button action listener
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "SELECT * FROM computer_shop";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Clear existing data
                    tableModel.setRowCount(0);

                    // Populate table with data from the database
                    while (resultSet.next()) {
                        String modelID = resultSet.getString("modelID");
                        String name = resultSet.getString("name");
                        String price = resultSet.getString("price");
                        String date = resultSet.getString("date");
                        tableModel.addRow(new Object[]{modelID, name, price, date});
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ComputerShopForm.this, "Error retrieving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Update button action listener
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String modelID = modelIDField.getText();
                    String name = nameField.getText();
                    String price = priceField.getText();
                    String date = dateField.getText();

                    try {
                        String query = "UPDATE computer_shop SET name = ?, price = ?, date = ? WHERE modelID= ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, price);
                        preparedStatement.setString(3, date);
                        preparedStatement.setString(4, modelID);

                        preparedStatement.executeUpdate();

                        // Update data in the table model
                        tableModel.setValueAt(modelID, selectedRow, 0);
                        tableModel.setValueAt(name, selectedRow, 1);
                        tableModel.setValueAt(price, selectedRow, 2);
                        tableModel.setValueAt(date, selectedRow, 3);

                        JOptionPane.showMessageDialog(ComputerShopForm.this, "Record updated successfully!");

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(ComputerShopForm.this, "Error updating record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(ComputerShopForm.this, "Please select a row to update", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Delete button action listener
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String modelID = (String) tableModel.getValueAt(selectedRow, 0);

                    try {
                        String query = "DELETE FROM computer_shop WHERE modelID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, modelID);

                        preparedStatement.executeUpdate();

                        // Remove selected row from the table model
                        tableModel.removeRow(selectedRow);

                        JOptionPane.showMessageDialog(ComputerShopForm.this, "Record deleted successfully!");

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(ComputerShopForm.this, "Error deleting record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(ComputerShopForm.this, "Please select a row to delete", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Add MouseListener to the table to handle row selection
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    modelIDField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    priceField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    dateField.setText(tableModel.getValueAt(selectedRow, 3).toString());
                }
            }
        });

        // Set frame size and location
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    // Initialize database connection
    private void initializeDBConnection() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            String url = "jdbc:mysql://127.0.0.1:3306/computer_shop";
            String user = "root";
            String password = "rith123";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Configure buttons with styles and hover effects
    private void configureButton(JButton button, Color bgColor, Color hoverColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComputerShopForm().setVisible(true);
            }
        });
    }
}
