package model;

import java.util.ArrayList;
import java.util.Date;

public class Transaction
{
    int transactionId;
    User user;
    ArrayList<Ticket> tickets;
    double totalCost;
    Date purchaseDate;
    Card paymentCard;


    // Revisit after creating User
    public Transaction(User customer)
    {
        setUser(customer);
        totalCost = 0;
        tickets = new ArrayList<Ticket>();
        purchaseDate = new Date();
    }

    public void addTicket(Ticket t)
    {
        tickets.add(t);
        this.updateCost(t);
    }
    public void updateCost(Ticket t)
    {
      totalCost += t.getShowing().getTicketPrice();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", user=" + user +
                ", tickets=" + tickets +
                ", totalCost=" + totalCost +
                ", purchaseDate=" + purchaseDate +
                ", paymentCard=" + paymentCard +
                '}';
    }

    public void getPayment(String name, int number, int expMonth, int expYear, int cvv)
    {
            setPaymentCard(new Card(name, number, expMonth, expYear, cvv));
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Card getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(Card paymentCard) {
        this.paymentCard = paymentCard;
    }




}
