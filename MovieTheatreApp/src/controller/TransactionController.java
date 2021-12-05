package controller;

import model.Showing;
import model.User;
import view.RUTransactionView;

import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionController {

    private User user;
    private Showing showing;
    private ArrayList<Integer> purchasedSeatsIndex;

    public TransactionController(User user, Showing showing, ArrayList<Integer> purchasedSeatsIndex) {
        this.user = user;
        this.showing = showing;
        this.purchasedSeatsIndex = purchasedSeatsIndex;

        if(this.user.getRegistered()){
            this.createTransaction();
            RUTransactionView ruTransactionView = new RUTransactionView();
            ruTransactionView.setVisible(true);
            ruTransactionView.addReturnButtonListener(e -> {
                try {
                    TerminalController terminalController = new TerminalController(user);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    public void createTransaction() {

    }



}
