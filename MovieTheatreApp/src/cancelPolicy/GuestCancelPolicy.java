package cancelPolicy;

import model.Seat;
import model.Transaction;
import model.User;

public class GuestCancelPolicy implements CancelPolicy{

    @Override
    public void cancelTicket(User user, int transactionIndex, int seatIndex) {
        Transaction transaction = user.getPreviousPurchases().get(transactionIndex);
        Seat seat = user.getPreviousPurchases().get(transactionIndex).getPurchasedSeats().get(seatIndex);
        double price = (double) (transaction.getTotalCost()/transaction.getPurchasedSeats().size());


        //TODO sql method call to make this seat's transaction id = 0



        transaction.setTotalCost(transaction.getTotalCost()/transaction.getPurchasedSeats().size()
                *(transaction.getPurchasedSeats().size()-1));
        transaction.getPurchasedSeats().remove(seat);


        if (transaction.getPurchasedSeats()== null){
            user.getPreviousPurchases().remove(transaction);
        }
        //TODO sql method call to create MovieCredit




    }
}
