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

        this.welcomeView.addLoginButtonListener(e -> {
            LoginController loginController = new LoginController();
            welcomeView.setVisible(false);
        });

        this.welcomeView.addGuestButtonListener(e -> {
            GuestController guestController = new GuestController();
            welcomeView.setVisible(false);
        });




    }

}
