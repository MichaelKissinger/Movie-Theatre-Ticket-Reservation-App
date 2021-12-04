package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeView extends JFrame implements ActionListener {
    private JButton continueAsGuestButton;
    private JButton loginButton;

    public WelcomeView() {
        setSize(400, 300);
        setTitle("Theatre Welcome Page");

        JPanel buttonPanel = new JPanel();
        JPanel displayPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(2, 1));

        continueAsGuestButton = new JButton("Continue As Guest");
        loginButton = new JButton("Login");

        buttonPanel.add(continueAsGuestButton);
        buttonPanel.add(loginButton);

        displayPanel.add("Center", buttonPanel);

        add(displayPanel);

        continueAsGuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuestView theTerminal = new GuestView();

                // Shows the GUI
                theTerminal.setVisible(true);
                theTerminal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(false);

            }
        });
    }

    public void addLoginButtonListener(ActionListener listenerForLoginButton) {
        loginButton.addActionListener(listenerForLoginButton);
    }

    //public void addGuestButtonListener(ActionListener listenerForGuestButton) { }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
