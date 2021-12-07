package controller;

import model.RegisteredUser;
import model.Showing;
import model.Transaction;
import model.User;
import view.SelectSeatView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectedSeatController {

    private User user;
    private Showing showing;
    private ArrayList<Integer> purchasedSeatsIndex;

    public SelectedSeatController(User user, Showing showing) {

//        showing.

        this.user = user;
        this.showing = showing;
        this.purchasedSeatsIndex = new ArrayList<Integer>();
        SelectSeatView selectSeatView = new SelectSeatView(showing.getTicketPrice(), showing.getSeats());
        selectSeatView.setVisible(true);
        selectSeatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectSeatView.addFinishedButtonListener(e -> {
            for(String seat: selectSeatView.getSelectedSeats()){
                purchasedSeatsIndex.add(getSeatIndex(seat));
            }
            if(user.getRegistered()){
                try {
                    TransactionController transactionController = new TransactionController(user, showing, purchasedSeatsIndex, user.getCreditCard());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            else {
                TransactionPaymentController transactionPaymentController = new TransactionPaymentController(user, showing, purchasedSeatsIndex);
            }
            selectSeatView.setVisible(false);
        });

    }

    public int getSeatIndex(String seat){
        return ((seat.charAt(0) - 'A') * 5) + Character.getNumericValue(seat.charAt(1))-1;
    }


}
