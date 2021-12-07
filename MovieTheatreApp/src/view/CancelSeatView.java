package view;

import model.Seat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CancelSeatView extends JFrame{
    JButton backButton, cancelButton;
    JList display;

    public CancelSeatView(ArrayList<Seat> seats){
        setSize(800, 650);
        setTitle("Select a seat to cancel");
        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel titlePanel = new JPanel();

        displayPanel.setLayout(new BorderLayout());

        buttonPanel.setLayout(new GridLayout(1,2));
        backButton = new JButton("Back");
        cancelButton = new JButton("Cancel selected seat");
        buttonPanel.add(backButton);
        buttonPanel.add(cancelButton);

        titlePanel.add(new JLabel("Please select a seat to cancel"));
        display = new JList(seats.toArray());
        display.setVisibleRowCount(20);
        display.setFixedCellHeight(20);
        display.setFixedCellWidth(500);

        JScrollPane sp = new JScrollPane(display);
        displayPanel.add("Center", sp);
        displayPanel.add("South", buttonPanel);
        displayPanel.add("North", titlePanel);
        add(displayPanel);
        setVisible(true);


    }
    public void addBackButtonListener(ActionListener e){
        backButton.addActionListener(e);
    }
    public void addCancelButtonListener(ActionListener e){
        cancelButton.addActionListener(e);
    }
    public int getListIndex(){
        return display.getSelectedIndex();
    }


}
