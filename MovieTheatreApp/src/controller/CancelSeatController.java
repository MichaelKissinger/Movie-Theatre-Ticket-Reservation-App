package controller;

import cancelPolicy.CancelPolicy;
import cancelPolicy.GuestCancelPolicy;
import cancelPolicy.RegisteredCancelPolicy;
import model.Seat;
import model.Transaction;
import model.User;
import view.CancelSeatView;

import javax.swing.*;
import java.util.ArrayList;

public class CancelSeatController {
    private User user;
    Transaction transaction;
    Seat seat;
    CancelPolicy cancelPolicy;

    public CancelSeatController(User user, Transaction transaction){
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
            cancelPolicy.cancelTicket(cancelledSeats, user, transaction);





            //TODO search the seat in the database,

        });

        cancelSeatView.addBackButtonListener(e->{
            //TODO implement terminalview here
        });





    }



}

=======
//package controller;
//
//import model.Seat;
//import model.Transaction;
//import model.User;
//import view.CancelSeatView;
//
//import javax.swing.*;
//
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
>>>>>>> ca2c62b54a6a4585558f36d92fe4edeed51b71f6
