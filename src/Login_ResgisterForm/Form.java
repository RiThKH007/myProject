package Login_ResgisterForm;

import constants.CommonConstants;

import javax.swing.*;

public class Form extends JFrame {
    //constructor
    public Form(String title){
        super(title);
        setSize(520,680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);
    }
}
