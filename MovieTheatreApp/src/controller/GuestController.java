package controller;

import model.LoginChecker;
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
            try {
                ordinaryUser = LoginChecker.AuthenticateOrdinaryUser(email);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if(ordinaryUser == null){
                // CREATE USER HERE
                // ASSIGN NEW USER TO ordinaryUSER
            }
            try {
                TerminalController terminalController = new TerminalController(ordinaryUser);
                guestView.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
    }
}
