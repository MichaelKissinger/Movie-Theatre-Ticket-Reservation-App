package controller;

import model.Showing;
import model.Transaction;
import model.User;
import view.SelectSeatView;

import javax.swing.*;
import java.util.ArrayList;

public class SelectedSeatController {

    private User user;
    private Showing showing;
    private ArrayList<Integer> purchasedSeats;

    public SelectedSeatController(User user, Showing showing) {

        this.user = user;
        this.showing = showing;
        this.purchasedSeats = new ArrayList<Integer>();
        SelectSeatView selectSeatView = new SelectSeatView();
        selectSeatView.setVisible(true);
        selectSeatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectSeatView.addFinishedButtonListener(e -> {
            for(String seat: selectSeatView.getSelectedSeats()){
                purchasedSeats.add(getSeatIndex(seat));
            }

            //TransactionController transactionController = new TransactionController(user, showing, purchasedSeatsIndex)


        });

    }

    public int getSeatIndex(String seat){
        return ((seat.charAt(0) - 'A') * 5) + Character.getNumericValue(seat.charAt(1));
    }


}
