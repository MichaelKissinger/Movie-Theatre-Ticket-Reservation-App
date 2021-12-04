package controller;

import view.*;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeController {

    WelcomeView welcomeView;


    public WelcomeController(WelcomeView theTerminal) {

        this.welcomeView = theTerminal;

        this.welcomeView.addLoginButtonListener(new LoginButtonListener());



    }

    class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            LoginController loginController = new LoginController();
            welcomeView.setVisible(false);
        }
    }

}
