package Login_ResgisterForm;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_GUI extends Form{
    public Register_GUI() {
        super("Register");
        addGUIComponents();
    }
    private void addGUIComponents(){
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setBounds(0,25,520,100);
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(registerLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30,185,400,25);
        usernameLabel.setForeground(CommonConstants.SECONDARY_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN,24));

        JTextField usernameFiled = new JTextField();
        usernameFiled.setBounds(30,150,450,55);
        usernameFiled.setBackground(CommonConstants.SECONDARY_COLOR);
        usernameFiled.setForeground(CommonConstants.TEXT_COLOR);
        usernameFiled.setFont(new Font("Dialog",Font.PLAIN,14));

        add(usernameLabel);
        add(usernameFiled);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30,255,400,25);
        passwordLabel.setForeground(CommonConstants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN,18));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30,255,400,25);
        passwordField.setBackground(CommonConstants.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN,24));

        add(passwordLabel);
        add(passwordField);

        JLabel repasswordLabel = new JLabel("Re-enter Password:");
        repasswordLabel.setBounds(30,365,400,25);
        repasswordLabel.setBackground(CommonConstants.SECONDARY_COLOR);
        repasswordLabel.setForeground(CommonConstants.TEXT_COLOR);
        repasswordLabel.setFont(new Font("Dialog", Font.PLAIN,24));

        JPasswordField repasswordField = new JPasswordField();
        repasswordField.setBounds(30,395,450,25);
        repasswordField.setBackground(CommonConstants.SECONDARY_COLOR);
        repasswordField.setForeground(CommonConstants.TEXT_COLOR);
        repasswordField.setFont(new Font("Dialog", Font.PLAIN,24));

        add(repasswordLabel);
        add(repasswordField);

        JButton registerbtn = new JButton("Register");
        registerbtn.setFont(new Font("Dialog",Font.BOLD,18));
        registerbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerbtn.setBackground(CommonConstants.TEXT_COLOR);
        registerbtn.setBounds(125,520,250,50);
        registerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameFiled.getText();
                String password = new String(passwordField.getPassword());
                String rePassword = new String(repasswordField.getPassword());

                
            }
        });

    }
}
