package model;


public class Ticket
{
    private int ticketId;
    private Showing showing;
    private Seat seat;

    public Ticket(int id, Seat theSeat, Showing theShowing)
    {
        setTicketId(id);
        setSeat(theSeat);
        setShowing(theShowing);
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", showing=" + showing +
                ", seat=" + seat +
                '}';
    }

}
