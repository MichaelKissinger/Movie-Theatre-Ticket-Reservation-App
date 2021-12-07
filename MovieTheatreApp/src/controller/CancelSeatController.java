
package controller;

import cancelPolicy.CancelPolicy;
import cancelPolicy.GuestCancelPolicy;
import cancelPolicy.RegisteredCancelPolicy;
import model.Seat;
import model.Transaction;
import model.User;
import view.CancelSeatView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;


//public class CancelSeatController {
//    private User user;
//    Transaction transaction;
//    Seat seat;
//
//    public CancelSeatController(User user, int index){
//        CancelSeatView cancelSeatView =
//                new CancelSeatView(user.getPreviousPurchases().get(index).getPurchasedSeats());
//        cancelSeatView.setVisible(true);
//
//        cancelSeatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        cancelSeatView.addCancelButtonListener(e->{
//            int seatIndex = cancelSeatView.getListIndex();
//            seat = user.getPreviousPurchases().get(index).getPurchasedSeats().get(seatIndex);
//            //TODO search the seat in the database,
//
//        });
//
//        cancelSeatView.addBackButtonListener(e->{
//            //TODO implement terminalview here
//        });
//
//
//
//
//
//    }
//
//
//
//}

public class CancelSeatController {
    private User user;
    Transaction transaction;
    Seat seat;
    CancelPolicy cancelPolicy;

    public CancelSeatController(User user, Transaction transaction){
        this.user= user;
        CancelSeatView cancelSeatView =
                new CancelSeatView(transaction.getPurchasedSeats(), transaction) ;
        cancelSeatView.setVisible(true);

        cancelSeatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cancelSeatView.addCancelButtonListener(e->{
            ArrayList<Seat> cancelledSeats = cancelSeatView.getCancelledSeats();
            if (user.getRegistered()){
                cancelPolicy = new RegisteredCancelPolicy();
            }else{
                cancelPolicy = new GuestCancelPolicy();
            }
            cancelPolicy.cancelTicket(cancelledSeats, transaction);

            CancelSuccessController  cancelSuccessController= new CancelSuccessController(user);


        });

        cancelSeatView.addBackButtonListener(e->{
            //TODO implement terminalview here
            try {
                TerminalController terminalController = new TerminalController(user);
                cancelSeatView.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });





    }



}


