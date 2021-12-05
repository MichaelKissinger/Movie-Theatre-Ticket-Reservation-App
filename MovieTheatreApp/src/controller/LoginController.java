package controller;

import view.*;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginController {

    private LoginView loginView;

    public LoginController(){
        // create login view
        loginView = new LoginView();
        // Shows the login GUI
        loginView.setVisible(true);
        loginView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.loginView.addAuthenticationListener(new AuthenticationListener());
    }

    public boolean authenticateUser(String username, String password) {
        if(username.equals("") && password.equals("")) return true;
        else return false;
    }

    class AuthenticationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String userNameEntry = loginView.getUsername();
            String userPasswordEntry = loginView.getPassword();

            boolean auth = authenticateUser(userNameEntry, userPasswordEntry);
            if(auth){
                User registeredUser = new RegisteredUser(1, "email", "address", userPasswordEntry);
                try {
                    TerminalController terminalController = new TerminalController(registeredUser);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                loginView.setVisible(false);
            }
            else {
                loginView.setErrorLabel("User not found.");
            }
        }
    }




}
