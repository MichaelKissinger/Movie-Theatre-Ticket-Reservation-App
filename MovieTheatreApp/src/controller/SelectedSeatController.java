package controller;

import model.Showing;
import model.User;
import view.SelectSeatView;

import javax.swing.*;
import java.util.ArrayList;

public class SelectedSeatController {

    private User user;
    private Showing showing;
    private ArrayList<String> purchasedSeats;

    public SelectedSeatController(User user, Showing showing) {

        this.user = user;
        this.showing = showing;
        SelectSeatView selectSeatView = new SelectSeatView();
        selectSeatView.setVisible(true);
        selectSeatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectSeatView.addFinishedButtonListener(e -> {
            purchasedSeats = selectSeatView.getSelectedSeats();
        });

    }
}
