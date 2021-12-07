package view;

import model.Email;
import model.Message;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


public class EmailView extends JFrame {

    JButton backButton;
    JTextArea message;
    JTextField subjectline;
    JList<Message> emailDisplay;


    @SuppressWarnings("rawtypes")
    public EmailView(ArrayList<Message>emails)
    {

        setSize(800, 650);
        setTitle("Account Mail");
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel southPanel = new JPanel();
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new BorderLayout(0, 0));

        JButton backButton = new JButton("Back");
        southPanel.add(backButton, BorderLayout.EAST);

        JPanel northPanel = new JPanel();
        getContentPane().add(northPanel, BorderLayout.NORTH);
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel pageLabel = new JLabel("Account Mail");
        pageLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        northPanel.add(pageLabel);

        JPanel centerPanel= new JPanel();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout(0, 0));

        emailDisplay = new JList(emails.toArray());
        emailDisplay.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        centerPanel.add(emailDisplay, BorderLayout.CENTER);

        JScrollBar scrollBar = new JScrollBar();
        emailDisplay.add(scrollBar, BorderLayout.WEST);

        JPanel messagePanel = new JPanel();
        centerPanel.add(messagePanel, BorderLayout.SOUTH);
        messagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel subject = new JLabel("Subject:");
        subject.setFont(new Font("Tahoma", Font.BOLD, 15));
        messagePanel.add(subject);

        subjectline = new JTextField();
        messagePanel.add(subjectline);
        subjectline.setColumns(80);

        message = new JTextArea();
        message.setColumns(80);
        message.setRows(8);
        messagePanel.add(messagePanel);


    }

    public int getListIndex() {
        return emailDisplay.getSelectedIndex();
    }

    public void addBackButtonListener(ActionListener listener){
        backButton.addActionListener(listener);
    }
}