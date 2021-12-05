package model;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Showing {

    private int showingId;
    private int movieId;
    private Date showTime;
    private double ticketPrice;
    private int theatreId;
    private ArrayList<Seat> seats;


    private JDBCConnect myJDBC;

//    Movie movie;
//    Theatre theatre;
//    int ticketCount;
//    Seat [][] seats;
//    ArrayList<Seat> selectedSeats;

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

//    public int getTicketCount() {
//        return ticketCount;
//    }
//
//    public void setTicketCount(int ticketCount) {
//        this.ticketCount = ticketCount;
//    }
//
//    public void setSeats(Seat[][] seats) {
//        this.seats = seats;
//    }
//
//    public ArrayList<Seat> getSelectedSeats() {
//        return selectedSeats;
//    }
//
//    public void setSelectedSeats(ArrayList<Seat> selectedSeats) {
//        this.selectedSeats = selectedSeats;
//    }
//
//    public void addSeat(int row, int col)
//    {
//        selectedSeats.add(seats[row][col]);
//    }
//
//    public void removeSeat(int row, int col)
//    {
//        selectedSeats.remove(seats[row][col]);
//    }
//
//    public Transaction checkout(User customer)
//    {
//        Transaction t = new Transaction(customer);
//        for (Seat s: selectedSeats)
//        {
//            t.addTicket(new Ticket(ticketCount++ , s, this));
//            s.setReserved(false);
//        }
//        return t;
//    }

//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }
//
//    public Theatre getTheatre() {
//        return theatre;
//    }
//
//    public void setTheatre(Theatre theatre) {
//        this.theatre = theatre;
//    }

//    public Seat[][] getSeats() {
//        return seats;
//    }

}
