package model;


public class Ticket
{
    int ticketId;
    Showing showing;
    Seat seat;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", showing=" + showing +
                ", seat=" + seat +
                '}';
    }

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


}
