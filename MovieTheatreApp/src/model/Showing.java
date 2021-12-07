package model;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Showing {

    private int showingId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    private int movieId;
    private Date showTime;
    private double ticketPrice;
    private int theatreId;
    private ArrayList<Seat> seats;


    private JDBCConnect myJDBC;

    public Showing(int showingId, int movieId, Date showTime, double ticketPrice, int theatreId) throws SQLException {
        myJDBC = new JDBCConnect();
        myJDBC.createConnection();
        this.showingId = showingId;
        this.movieId = movieId;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.theatreId = theatreId;

        initializeSeats();
    }

    public void initializeSeats() throws SQLException {
        seats = myJDBC.seatSetStatement(showingId);
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return this.showingId + ". " + this.showTime + "            $" + this.ticketPrice;
    }


}
