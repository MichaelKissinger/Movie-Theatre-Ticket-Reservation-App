package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener {

    private JTextField inputField, inputField2;
    private JButton enterButton;
    private JLabel loginLabel, passwordLabel;

    public LoginView() {
        setSize(400, 300);
        setTitle("Theatre Log In Page");

        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(3, 2));

        loginLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");


        inputPanel.add(loginLabel);
        inputPanel.add(passwordLabel);

        inputField = new JTextField(10);
        inputField2 = new JTextField(10);

        inputPanel.add(inputField);
        inputPanel.add(inputField2);

        displayPanel.add("North", buttonPanel);


        enterButton = new JButton("ENTER");
        inputPanel.add(enterButton);

        displayPanel.add("South", inputPanel);

        add(displayPanel);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userNameEntry = inputField.getText();
                String userPasswordEntry = inputField2.getText();

                TerminalView theTerminal = new TerminalView();
                // Shows the GUI
                theTerminal.setVisible(true);
                theTerminal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(false);

            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
