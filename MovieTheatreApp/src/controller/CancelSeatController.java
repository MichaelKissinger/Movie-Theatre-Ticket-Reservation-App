package controller;

import model.Seat;
import model.Transaction;
import model.User;
import view.CancelSeatView;

import javax.swing.*;

public class CancelSeatController {
    private User user;
    Transaction transaction;
    Seat seat;

    public CancelSeatController(User user, int index){
        CancelSeatView cancelSeatView =
                new CancelSeatView(user.getPreviousPurchases().get(index).getPurchasedSeats(),
                        transaction);
        cancelSeatView.setVisible(true);

        cancelSeatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cancelSeatView.addCancelButtonListener(e->{
            int seatIndex = cancelSeatView.getListIndex();
            seat = user.getPreviousPurchases().get(index).getPurchasedSeats().get(seatIndex);
            //TODO search the seat in the database,

        });

        cancelSeatView.addBackButtonListener(e->{
            //TODO implement terminalview here
        });





    }



}
