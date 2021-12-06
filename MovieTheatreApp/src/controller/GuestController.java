package controller;

import model.Database;
import model.User;
import view.GuestView;

import java.sql.SQLException;
import java.util.ArrayList;

public class GuestController {

    private User ordinaryUser;

    public GuestController() {
        GuestView guestView = new GuestView();
        guestView.setVisible(true);

        guestView.addEnterListener(e -> {
            String email = guestView.getEmail();
            Boolean emailCheck = null;

            // TO-DO
            // Validate Email

            // Check User exists in DB using email
            try {
                emailCheck = this.checkIfInDB(email);
                System.out.println("test 1");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            if(emailCheck == true) {
                // If yes - Get user
                try {
                    //Assigning user to object
                    ordinaryUser = this.findUser(email);
                    System.out.println("test 2");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                // If no - create a new user
                try {
                    Database.addUser(email);
                    System.out.println("test 3");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    //Assigning newly created user to object
                    ordinaryUser = this.findUser(email);
                    System.out.println(ordinaryUser);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

                try {
                    //Removed since this is determined above
//                    ordinaryUser = new User(1, "email", false);
                    TerminalController terminalController = new TerminalController(ordinaryUser);
                    guestView.setVisible(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

        });
    }

    public Boolean checkIfInDB(String email) throws SQLException {
        for (User u: Database.getUserDB()) {
            if (u.getEmail().equals(email)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public User findUser(String email) throws SQLException {
        ArrayList<User> myUserDB = Database.getUserDB();
        for (User u: myUserDB) {
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }


}
