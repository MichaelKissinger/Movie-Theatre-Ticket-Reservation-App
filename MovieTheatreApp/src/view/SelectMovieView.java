package view;

import controller.MovieController;
import model.Movie;
import model.Showing;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;

public class SelectMovieView extends JFrame {

    JButton backButton, proceedButton;
    JList display;

    public SelectMovieView(ArrayList<Movie> movies) {

        setSize(800, 650);
        setTitle("Theater Terminal Page");

        JPanel displayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(1, 2));
        displayPanel.setLayout(new BorderLayout());

        backButton = new JButton("Back");
        proceedButton = new JButton("Proceed");

        buttonPanel.add(backButton);
        buttonPanel.add(proceedButton);
        JLabel title = new JLabel("Please select a movie");
        inputPanel.add(title);

        display = new JList(movies.toArray());
        display.setVisibleRowCount(20);
        display.setFixedCellHeight(20);
        display.setFixedCellWidth(500);
        JScrollPane sp = new JScrollPane(display);


        displayPanel.add("Center", sp);
        displayPanel.add("South", buttonPanel);
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
