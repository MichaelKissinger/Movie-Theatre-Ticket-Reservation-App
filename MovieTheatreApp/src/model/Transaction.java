package model;

import java.util.ArrayList;
import java.util.Date;

public class Transaction
{
    int transactionId;
    User user;
    double totalCost;
    Date purchaseDate;
    CreditCard paymentCreditCard;
    ArrayList<Seat> purchasedSeats;
    JDBCConnect myJDBC;

    //Constructor for an initializing existing Transaction from DB.
    public Transaction(int transactionId, User user, double totalCost, Date purchaseDate, CreditCard paymentCreditCard, ArrayList<Seat> purchasedSeats)
    {
        this.transactionId = transactionId;
        this.user = user;
        this.totalCost = totalCost;
        this.purchaseDate = purchaseDate;
        this.paymentCreditCard = paymentCreditCard;
        this.purchasedSeats = purchasedSeats;
    }

    // Constructor for initializing a new Transaction and creating it in the DB
    public Transaction(User user)
    {
        setUser(user);
        totalCost = 0;
        purchaseDate = new Date();

        // CREATE TRANSACTION IN THE DB AND GET THE ID
        // this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", user=" + user +
                ", totalCost=" + totalCost +
                ", purchaseDate=" + purchaseDate +
                ", paymentCard=" + paymentCreditCard +
                '}';
    }

    public void getPayment(String name, int number, int expMonth, int expYear, int cvv)
    {
        //setPaymentCard(new CreditCard(name, number, expMonth, expYear, cvv));
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

    public ArrayList<Seat> getPurchasedSeats() {
        return purchasedSeats;
    }

    public void setPurchasedSeats(ArrayList<Seat> purchasedSeats) {
        this.purchasedSeats = purchasedSeats;
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

    public CreditCard getPaymentCard() {
        return paymentCreditCard;
    }

    public void setPaymentCard(CreditCard paymentCreditCard) {
        this.paymentCreditCard = paymentCreditCard;
    }




}
