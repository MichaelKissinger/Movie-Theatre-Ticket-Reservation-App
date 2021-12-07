package controller;

import model.User;
import view.CancelSuccessView;

import java.sql.SQLException;

public class CancelSuccessController {
    User user;

    public CancelSuccessController(User user){
        this.user = user;
        CancelSuccessView cancelSuccessView = new CancelSuccessView();
        cancelSuccessView.setVisible(true);
        cancelSuccessView.addReturnButtonListener(e->{
            try {
                TerminalController terminalController = new TerminalController(user);
                cancelSuccessView.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


    }
}
