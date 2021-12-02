package model;

import java.util.ArrayList;
import java.util.Date;

public class Showing {

    int showingId;
    Movie movie;
    Theatre theatre;
    Date showTime;
    double ticketPrice;
    Seat [][] seats;

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    int ticketCount;

    public Showing(int id, Date showTime, double ticketPrice, Movie m, Theatre t)
    {
        setShowingId(id);
        setShowTime(showTime);
        setTicketPrice(ticketPrice);
        setMovie(m);
        setTheatre(t);
        ticketCount = 0;

        seats =
        for (int i =0; i < 5; i++)
        {
            seats.add(new ArrayList<Seat>(5));
        }
    }

    // NEED TO FINISH
    public void pickSeat(int row, int col)
    {
        seats.get(row).get(col).reserved = True;
        reservedSeat = seats.get(row).get(col);
        double price = getTicketPrice();
    }

    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
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

    public ArrayList<ArrayList<Seat>> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<ArrayList<Seat>> seats) {
        this.seats = seats;
    }


    @Override
    public String toString() {
        return "Showing{" +
                "showingId=" + showingId +
                ", movie=" + movie +
                ", theatre=" + theatre +
                ", showTime=" + showTime +
                ", ticketPrice=" + ticketPrice +
                ", seats=" + seats +
                ", ticketCount=" + ticketCount +
                '}';
    }
}
