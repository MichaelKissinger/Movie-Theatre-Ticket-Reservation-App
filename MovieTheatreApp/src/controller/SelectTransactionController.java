package controller;

import cancelPolicy.CancelPolicy;
import cancelPolicy.GuestCancelPolicy;
import cancelPolicy.RegisteredCancelPolicy;
import model.Transaction;
import model.User;
import view.CancelSuccessView;
import view.SelectTransactionView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SelectTransactionController {
    private User user;
    Transaction selectedTransaction;
    CancelPolicy cancelPolicy;


    public SelectTransactionController(User user){
        this.user = user;

        ArrayList<Transaction> cancelable = new ArrayList<>();
        for(Transaction transaction:user.getPreviousPurchases()){
            Calendar c = Calendar.getInstance();
            c.setTime(transaction.getShowing().getShowTime());
            c.add(Calendar.HOUR, -72);
            Date latestCancelTime = c.getTime();
            Date date = new Date(System.currentTimeMillis());

            if (date.before(latestCancelTime)){
                cancelable.add(transaction);
            }

        }
        SelectTransactionView selectTransactionView = new SelectTransactionView(cancelable);
        selectTransactionView.setVisible(true);
        selectTransactionView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        selectTransactionView.addProceedButtonListener(e->{
            selectedTransaction = selectTransactionView.getSelectedTransaction();
            CancelSeatController cancelSeatController =
                    new CancelSeatController(user, selectedTransaction);
        });

        selectTransactionView.addCancelAllButtonListener(e->{
            selectedTransaction = selectTransactionView.getSelectedTransaction();
            if (user.getRegistered()){
                cancelPolicy = new RegisteredCancelPolicy();
            }else{
                cancelPolicy = new GuestCancelPolicy();
            }
            cancelPolicy.cancelTicket(selectedTransaction.getPurchasedSeats(), selectedTransaction);
            CancelSuccessController cancelSuccessController = new CancelSuccessController(user);
            selectTransactionView.setVisible(false);


        });

        selectTransactionView.addBackButtonListener(e->{
            try {
                TerminalController terminalController = new TerminalController(user);
                selectTransactionView.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


    }
}
