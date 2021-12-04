package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TerminalView extends JFrame implements ActionListener {

    JButton option1, option2, option3, option4, option5, option6, enterButton;
    JTextArea display;
    JTextField inputField;

    public TerminalView() {

        setSize(800, 650);
        setTitle("Theater Terminal Page");

        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(2, 3));

        option1 = new JButton("Search for a Movie");
        option2 = new JButton("Buy Movie Ticket");
        option3 = new JButton("Cancel A Movie ticket");
        option4 = new JButton("Register");
        option5 = new JButton("View Email");
        option6 = new JButton("Quit application");

        option6.addActionListener(this);
//
//        buttonPanel.add(option1);
//        buttonPanel.add(option2);
//        buttonPanel.add(option3);
//        buttonPanel.add(option4);
//        buttonPanel.add(option5);
//        buttonPanel.add(option6);


        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SeatView theSeats = new SeatView();
                // Shows the GUI
                theSeats.setVisible(true);
                theSeats.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(false);
            }
        });


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

    public void clearDisplay() {
        display.setText("");
    }

    public void addText(String string) {
        display.append(string + "");
    }

    public void addEnterButtonListener(ActionListener listener) {
        enterButton.addActionListener(listener);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == option6) {
            System.exit(0);
        }
    }
    public void addSearchMovieListener(ActionListener e){
        option1.addActionListener(e);
    }

    public void addBuyMovieTicketListener(ActionListener e){
        option2.addActionListener(e);// goes to seats vioew
    }

    public void addCancelTicketListener(ActionListener e){
        option3.addActionListener(e);
    }

    public void registerListener(ActionListener e){
        option4.addActionListener(e);
    }

    public void viewEmailListener(ActionListener e){
        option5.addActionListener(e);
    }







    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }



}
