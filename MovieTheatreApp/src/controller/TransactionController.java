package controller;

import model.CreditCard;
import model.Showing;
import model.Transaction;
import model.User;
import view.PaymentView;
import view.TransactionConfirmationView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionController {

    private User user;
    private Showing showing;
    private ArrayList<Integer> purchasedSeatsIndex;
    private CreditCard paymentCard;

    public TransactionController(User user, Showing showing, ArrayList<Integer> purchasedSeatsIndex, CreditCard paymentCard) throws SQLException {
        this.user = user;
        this.showing = showing;
        this.purchasedSeatsIndex = purchasedSeatsIndex;
        this.paymentCard = paymentCard;
        this.createTransaction();

        TransactionConfirmationView transactionConfirmationView = new TransactionConfirmationView();
        transactionConfirmationView.setVisible(true);
        transactionConfirmationView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        transactionConfirmationView.addReturnButtonListener(e -> {
            try {
                TerminalController terminalController = new TerminalController(user);
                transactionConfirmationView.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }


    public void createTransaction() throws SQLException {
        double totalCost = showing.getTicketPrice() * purchasedSeatsIndex.size();
        Transaction transaction = new Transaction(user, totalCost, paymentCard, showing.getShowingId());
        for(int index: purchasedSeatsIndex){
            showing.getSeats().get(index).setTransactionID(transaction.getTransactionId());
        }

        showing.setAvailability();

    }




}
