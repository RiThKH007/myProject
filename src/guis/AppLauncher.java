package guis;

import db.MyJDBC;
import guis.Form;
import guis.LoginFormGUI;
import guis.RegisterFormGUI;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                // instantiate a LoginFormGUI obj and make it visible
                new LoginFormGUI().setVisible(true);
            }
        });
    }
}
