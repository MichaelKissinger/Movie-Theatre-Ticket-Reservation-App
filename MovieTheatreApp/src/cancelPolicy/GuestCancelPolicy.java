package cancelPolicy;

import model.JDBCConnect;
import model.Seat;
import model.Transaction;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GuestCancelPolicy implements CancelPolicy{



    @Override
    public void cancelTicket(ArrayList<Seat> cancelledSeats, Transaction transaction) {
        JDBCConnect myJDBC = new JDBCConnect();

        myJDBC.createConnection();
        int numberOfTickets = cancelledSeats.size();
        System.out.println(cancelledSeats);
        System.out.println(transaction);

        for(Seat seat:cancelledSeats){
            try {
                myJDBC.updateSeatDB(seat.getShowingId(), seat.getRow(), seat.getCol());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        transaction.getPurchasedSeats().remove(cancelledSeats);

        double amount = (double)numberOfTickets*transaction.getShowing().getTicketPrice()*0.85;
        String creditCode = "Refund";

        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        c.add(Calendar.YEAR, 1);
        Date expiryDate = c.getTime();


        try {
            myJDBC.addMovieCreditToDB(
                    creditCode, expiryDate, amount, transaction.getUser().getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
