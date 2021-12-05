package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TerminalView extends JFrame implements ActionListener {

    JButton searchButton, buyTicketButton, cancelTicketButton, registerButton, viewEmailButton, QuitButton, enterButton;
    JTextArea display;
    JTextField inputField;
    String flag;

    public TerminalView() {
        flag = "";
        setSize(800, 650);
        setTitle("Theater Terminal Page");

        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(2, 3));

        searchButton = new JButton("Search for a Movie");
        buyTicketButton = new JButton("Buy Movie Ticket");
        cancelTicketButton = new JButton("Cancel A Movie ticket");
        registerButton = new JButton("Register");
        viewEmailButton = new JButton("View Email");
        QuitButton = new JButton("Quit application");

        QuitButton.addActionListener(this);

        buttonPanel.add(searchButton);
        buttonPanel.add(buyTicketButton);
        buttonPanel.add(cancelTicketButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(viewEmailButton);
        buttonPanel.add(QuitButton);

        displayPanel.add("North", buttonPanel);

        display = new JTextArea(30, 60);
        display.setLineWrap(true);

        displayPanel.add("Center", display);

        inputField = new JTextField(10);

        inputPanel.add(inputField);

        enterButton = new JButton("ENTER");

        inputPanel.add(enterButton);

        displayPanel.add("South", inputPanel);

        add(displayPanel);
    }

    public void setVisible() {
        setVisible(true);
    }

    public int getIntegerInput() {
        int temp = Integer.parseInt(inputField.getText());
        inputField.setText("");
        return temp;
    }

    public String getStringInput() {
        String temp = inputField.getText();
        inputField.setText("");
        return temp;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void clearDisplay() {
        display.setText("");
    }

    public void addText(String string) {
        display.append(string + "");
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    // BUTTON LISTENERS

    public void addEnterButtonListener(ActionListener listener) {
        enterButton.addActionListener(listener);
    }

    public void addSearchMovieListener(ActionListener e){
        searchButton.addActionListener(e);
    }

    public void addBuyMovieTicketListener(ActionListener e){
        buyTicketButton.addActionListener(e);// goes to seats vioew
    }

    public void addCancelTicketListener(ActionListener e){
        cancelTicketButton.addActionListener(e);
    }

    public void addRegisterListener(ActionListener e){
        registerButton.addActionListener(e);
    }

    public void addViewEmailListener(ActionListener e){
        viewEmailButton.addActionListener(e);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == QuitButton) {
            System.exit(0);
        }
    }

}
