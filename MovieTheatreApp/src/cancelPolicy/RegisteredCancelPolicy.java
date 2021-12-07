package cancelPolicy;

import model.Seat;
import model.Transaction;
import model.User;

import java.util.ArrayList;
import java.util.Date;

public class RegisteredCancelPolicy implements CancelPolicy{



    @Override
    public void cancelTicket(ArrayList<Seat> cancelledSeats, User user, Transaction transaction) {
        int numberOfTickets = cancelledSeats.size();


        //TODO sql method call to make this seat's transaction id = 0


        double amount = (double)numberOfTickets*transaction.getShowing().getTicketPrice();
        String creditCode = "idk what to put";
        //TODO change creditcode
//        Date expiryDate = new Date().




        if (transaction.getPurchasedSeats()== null){
            user.getPreviousPurchases().remove(transaction);
        }
        //TODO sql method call to create MovieCredit




    }
}
