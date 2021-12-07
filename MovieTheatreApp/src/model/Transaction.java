package model;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Transaction
{
    int transactionId;
    int userId;
    double totalCost;
    Date purchaseDate;
    int creditCardId;
    int showingId;

    User user;
    CreditCard paymentCreditCard;
    ArrayList<Seat> purchasedSeats = new ArrayList<Seat>();
    Showing showing;

    JDBCConnect myJDBC;
    Database database;

    //Constructor for an initializing existing Transaction from DB.
    public Transaction(int transactionId, int userId, double totalCost,
                       Date purchaseDate, int paymentCreditCard, int showingId) throws SQLException {
        this.transactionId = transactionId;
        this.userId = userId;
        this.totalCost = totalCost;
        this.purchaseDate = purchaseDate;
        this.creditCardId = paymentCreditCard;
        this.showingId = showingId;
        database = Database.getDatabase();
        setUser(userId);
        setSeats(transactionId);
        setShowing(showingId);
    }

    // Constructor for initializing a new Transaction and creating it in the DB
    public Transaction(User user, double totalCost, CreditCard paymentCreditCard, int showingId) throws SQLException {
        this.user = user;
        this.totalCost = totalCost;
        this.paymentCreditCard = paymentCreditCard;

        myJDBC = new JDBCConnect();
        myJDBC.createConnection();
        this.transactionId = myJDBC.addTransactionToDB(user, totalCost, paymentCreditCard, showingId);

    }
    public Showing getShowing(){
        return showing;
    }

    public void setUser(int userId) throws SQLException {
        for (User u: database.getUserDB()) {
            if (userId == u.getUserId()) {
                this.user = u;
            }
        }
    }

    public void setSeats(int transactionId) throws SQLException {
        for (Seat s: database.getSeatDB()) {
            if(transactionId == s.getTransactionID()){
                this.purchasedSeats.add(s);
            }
        }
    }

    public void setShowing(int showingId) throws SQLException {
        for (Showing s: database.getShowingDB()) {
            if(showingId == s.getShowingId()){
                this.showing = s;
            }
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", user=" + user +
                ", totalCost=" + totalCost +
                ", purchaseDate=" + purchaseDate +
                ", paymentCard=" + paymentCreditCard +
                ", purchased Seats=" + purchasedSeats +
                ", showing=" + showing +
                '}' + '\n';
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
