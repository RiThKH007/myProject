package Login_ResgisterForm;

import com.mysql.cj.log.Log;
import constants.CommonConstants;
import db.MyJDBC;
import guis.RegisterFormGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFormGUI extends Form{
    public LoginFormGUI() {
        super("Login");
        addGuiComponents();
    }
    private void addGuiComponents(){
        JLabel loginlable = new JLabel("Login");
        loginlable.setBounds(0,25,520,100);

        loginlable.setForeground(CommonConstants.TEXT_COLOR);

        loginlable.setFont(new Font("Dialog",Font.BOLD,40));

        loginlable.setHorizontalAlignment(SwingConstants.CENTER);

        add(loginlable);

        JLabel usernamelable = new JLabel("Username:");
        usernamelable.setBounds(30,150,400,25);
        usernamelable.setForeground(CommonConstants.SECONDARY_COLOR);
        usernamelable.setFont(new Font("Dialog", Font.PLAIN,24));

        JTextField usernamefield = new JTextField();
        usernamefield.setBounds(30,185,450,55);
        usernamefield.setBackground(CommonConstants.SECONDARY_COLOR);
        usernamefield.setForeground(CommonConstants.TEXT_COLOR);
        usernamefield.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(usernamelable);
        add(usernamefield);

        JLabel uerspassword = new JLabel("Password:");
        uerspassword.setBounds(30,335,400,25);
        uerspassword.setForeground(CommonConstants.TEXT_COLOR);
        uerspassword.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField passwordfield = new JPasswordField();
        passwordfield.setBounds(30,360,450,55);
        passwordfield.setBackground(CommonConstants.SECONDARY_COLOR);
        passwordfield.setForeground(CommonConstants.TEXT_COLOR);
        passwordfield.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(uerspassword);
        add(passwordfield);

        JButton loginbtn = new JButton("Login");
        loginbtn.setFont(new Font("Dialog",Font.BOLD,18));

        loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginbtn.setBackground(CommonConstants.TEXT_COLOR.brighter());
        loginbtn.setBounds(125,520,250,50);
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernamefield.getText();

                String password = new String(passwordfield.getPassword());

                if(MyJDBC.validateLogin(username, password)){
                    JOptionPane.showMessageDialog(LoginFormGUI.this,
                            "Login SuccessFul!");
                }else{
                    JOptionPane.showMessageDialog(LoginFormGUI.this,
                            "Login Failed...");
                }
            }
        });
        add(loginbtn);

        JLabel registerLabel = new JLabel("Not a user? Register Here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFormGUI.this.dispose();
                new RegisterFormGUI().setVisible(true);
            }
        });
        registerLabel.setBounds(125,600,250,30);
        add(registerLabel);
    }
}
