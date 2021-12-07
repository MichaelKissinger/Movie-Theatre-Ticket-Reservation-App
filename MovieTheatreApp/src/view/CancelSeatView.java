package view;

import model.Seat;
import model.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CancelSeatView extends JFrame implements ActionListener{
    JButton backButton, cancelButton;
    ArrayList<String> selectedSeats;


    public CancelSeatView(ArrayList<Seat> seats, Transaction transaction){
        selectedSeats = new ArrayList<String>();
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
        JPanel display = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(Seat i: seats){
            JButton btn = new JButton(i.getCol() + i.getRow());
            btn.addActionListener(this);
            display.add( new JButton(seats.toString()));
        }

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



    public void actionPerformed(ActionEvent e){
        for(String seat:selectedSeats) {
            if(seat.equals(((JButton)(e.getSource())).getText())){
                selectedSeats.remove(seat);
            }
            ((JButton)e.getSource()).setBackground(null);
            return;
        }
        selectedSeats.add(((JButton)e.getSource()).getText());
        ((JButton)e.getSource()).setBackground(Color.lightGray);
    }


}
