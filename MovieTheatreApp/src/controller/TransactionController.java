package controller;

import model.Showing;
import model.Transaction;
import model.User;
import view.PaymentView;
import view.TransactionConfirmationView;

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
            TransactionConfirmationView transactionConfirmationView = new TransactionConfirmationView();
            transactionConfirmationView.setVisible(true);
            transactionConfirmationView.addReturnButtonListener(e -> {
                try {
                    TerminalController terminalController = new TerminalController(user);
                    transactionConfirmationView.setVisible(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });
        }
        else {
            PaymentView paymentView = new PaymentView();
            paymentView.setVisible(true);
            paymentView.addPurchaseButtonListener(e -> {
                this.createTransaction();
                paymentView.setVisible(false);
                TransactionConfirmationView transactionConfirmationView = new TransactionConfirmationView();
                transactionConfirmationView.setVisible(true);
                transactionConfirmationView.addReturnButtonListener(event -> {
                    try {
                        TerminalController terminalController = new TerminalController(user);
                        transactionConfirmationView.setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                });
            });
        }
    }

    public void createTransaction() {
        Transaction transaction = new Transaction(user);

        for(int index: purchasedSeatsIndex){
            showing.getSeats().get(index).setTransactionID();
        }
        // TO_DO:
        // Create Transaction Object and Push to DB
        // Iterate through purchasedSeatsIndex and get seat from showing and update transaction ID
    }



}
