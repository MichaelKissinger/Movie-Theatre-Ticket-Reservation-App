package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestView extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton enterButton;
    private JLabel guestLabel;

    public GuestView() {
        setSize(400, 300);
        setTitle("Theatre Guest Page");

        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(3, 1));

        guestLabel = new JLabel("Email");

        inputPanel.add(guestLabel);


        inputField = new JTextField(10);

        inputPanel.add(inputField);

        displayPanel.add("North", buttonPanel);



        enterButton = new JButton("ENTER");
        inputPanel.add(enterButton);

        displayPanel.add("South", inputPanel);

        add(displayPanel);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userNameEntry = inputField.getText();

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
