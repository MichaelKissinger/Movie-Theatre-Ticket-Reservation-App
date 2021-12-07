package controller;

import model.Transaction;
import model.User;
import view.SelectTransactionView;

import javax.swing.*;
import java.sql.SQLException;

public class SelectTransactionController {
    private User user;
    Transaction transaction;

    public SelectTransactionController(User user){
        this.user = user;

        SelectTransactionView selectTransactionView = new SelectTransactionView(user.getPreviousPurchases());
        selectTransactionView.setVisible(true);
        selectTransactionView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectTransactionView.addProceedButtonListener(e->{
            int index = selectTransactionView.getListIndex();
            transaction = user.getPreviousPurchases().get(index);
//            CancelSeatController cancelSeatController = new CancelSeatController(user, transaction);
        });

        selectTransactionView.addCancelAllButtonListener(e->{
            int index = selectTransactionView.getListIndex();
            transaction = user.getPreviousPurchases().get(index);
            try {
                TerminalController terminalController = new TerminalController(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        });

        selectTransactionView.addBackButtonListener(e->{
            try {
                TerminalController terminalController = new TerminalController(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


    }
}
