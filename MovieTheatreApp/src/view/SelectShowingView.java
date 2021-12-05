package view;

import controller.MovieController;
import model.Movie;
import model.Showing;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;

public class SelectShowingView extends JFrame {

    JButton backButton, proceedButton;
    JList display;

    public SelectShowingView(ArrayList<Showing> showings) {

        setSize(800, 650);
        setTitle("Theater Terminal Page");

        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(2, 3));

        backButton = new JButton("Back");
        proceedButton = new JButton("Proceed");

        buttonPanel.add(backButton);
        buttonPanel.add(proceedButton);

        displayPanel.add("South", buttonPanel);

        display = new JList(showings.toArray());
        displayPanel.add("Center", display);
        displayPanel.add("North", inputPanel);
        add(displayPanel);

    }

    public int getListIndex() {
        return display.getSelectedIndex();
    }

    // BUTTON LISTENERS
    public void addProceedButtonListener(ActionListener listener) {
        proceedButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener){
        backButton.addActionListener(listener);
    }

}

