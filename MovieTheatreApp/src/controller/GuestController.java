package controller;

import model.User;
import view.GuestView;

import java.sql.SQLException;

public class GuestController {

    private User ordinaryUser;

    public GuestController() {
        GuestView guestView = new GuestView();
        guestView.setVisible(true);

        guestView.addEnterListener(e -> {
            String email = guestView.getEmail();

            // TO-DO
                // Validate Email
                // Check User exists in DB using email
                // If yes - Get user
                // If no - create a new user

            try {
                ordinaryUser = new User(1, "email", false);
                TerminalController terminalController = new TerminalController(ordinaryUser);
                guestView.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
    }
}
