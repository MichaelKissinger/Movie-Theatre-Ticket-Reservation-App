package controller;

import model.CreditCard;
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
    private CreditCard paymentCard;

    public TransactionController(User user, Showing showing, ArrayList<Integer> purchasedSeatsIndex, CreditCard paymentCard) {
        this.user = user;
        this.showing = showing;
        this.purchasedSeatsIndex = purchasedSeatsIndex;
        this.paymentCard = paymentCard;
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


    public void createTransaction() {
        //Transaction transaction = new Transaction(user);

        for(int index: purchasedSeatsIndex){
            //showing.getSeats().get(index).setTransactionID();
            return;
        }
        // TO_DO:
        // Create Transaction Object and Push to DB
        // Iterate through purchasedSeatsIndex and get seat from showing and update transaction ID
    }



}
