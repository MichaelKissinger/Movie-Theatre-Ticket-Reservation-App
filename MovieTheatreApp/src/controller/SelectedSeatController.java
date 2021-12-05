package controller;

import model.Showing;
import model.User;
import view.SelectSeatView;

import javax.swing.*;

public class SelectedSeatController {

    private User user;
    private Showing showing;

    public SelectedSeatController(User user, Showing showing) {

        this.user = user;
        this.showing = showing;
        SelectSeatView selectSeatView = new SelectSeatView();
        selectSeatView.setVisible(true);
        selectSeatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectSeatView.addFinishedButtonListener(e -> {

        });

    }
}
