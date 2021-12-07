package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener {

    private JTextField inputField, inputField2;
    private JButton enterButton;
    private JLabel loginLabel, passwordLabel, blankLabel, errorLabel;

    public LoginView() {
        setSize(400, 300);
        setTitle("Theatre Log In Page");

        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(4, 2));

        loginLabel = new JLabel("Email");
        passwordLabel = new JLabel("Password");

        inputField = new JTextField(10);
        inputField2 = new JTextField(10);

        enterButton = new JButton("ENTER");

        blankLabel = new JLabel("");
        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);

        inputPanel.add(loginLabel);
        inputPanel.add(passwordLabel);
        inputPanel.add(inputField);
        inputPanel.add(inputField2);
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
        return inputField.getText();
    }

    public String getPassword(){
        return inputField2.getText();
    }

    public void setErrorLabel(String error) { errorLabel.setText(error); }



    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
