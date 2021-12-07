package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginView extends JFrame implements ActionListener {

    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton enterButton;
    private JLabel loginLabel, passwordLabel, blankLabel, errorLabel;

    public LoginView() {
        setSize(600, 300);
        setTitle("Theatre Log In Page");

        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(4, 2));

        loginLabel = new JLabel("Email");
        passwordLabel = new JLabel("Password");

        usernameInput = new JTextField(20);
        passwordInput = new JPasswordField(20);

        enterButton = new JButton("ENTER");

        blankLabel = new JLabel("");
        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);

        inputPanel.add(loginLabel);
        inputPanel.add(passwordLabel);
        inputPanel.add(usernameInput);
        inputPanel.add(passwordInput);
        inputPanel.add(enterButton);
        inputPanel.add(blankLabel);
        inputPanel.add(errorLabel);

        displayPanel.add("North", buttonPanel);
        displayPanel.add("South", inputPanel);

        add(displayPanel);

    }

    public void addAuthenticationListener(ActionListener listenerForAuthentication) {
        enterButton.addActionListener(listenerForAuthentication);
    }

    public String getUsername(){
        return usernameInput.getText();
    }

    public String getPassword(){
        return new String(passwordInput.getPassword());
    }

    public void setErrorLabel(String error) { errorLabel.setText(error); }



    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
