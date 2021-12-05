package controller;

import model.Showing;
import model.User;
import view.SeatView;

import javax.swing.*;

public class SeatController {

    private User user;
    private Showing showing;

    public SeatController(User user, Showing showing) {

        this.user = user;
        this.showing = showing;
        SeatView seatView = new SeatView();
        seatView.setVisible(true);
        seatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
