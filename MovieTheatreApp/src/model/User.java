package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class User
{
    protected int userId;
    protected String email;
    protected Boolean isRegistered;
    protected ArrayList<MovieCredit> userCredit;
    protected ArrayList<Transaction> previousPurchases;

    private JDBCConnect myJDBC;

    public User(int userId, String email, Boolean isRegistered) throws SQLException {
        myJDBC = new JDBCConnect();
        myJDBC.createConnection();
        setUserId(userId);
        setEmail(email);
        this.isRegistered = isRegistered;

        //TODO add in transactions

        initializeUserCredits();
//        initializeUserTransactions();
        //TODO DEBUG THIS

    }

    private void initializeUserTransactions() throws SQLException{
        this.previousPurchases = myJDBC.transactionsStatement(userId);
    }

    public void initializeUserCredits() throws SQLException {
        this.userCredit = myJDBC.creditSetStatement(userId);
    }

    // TO_DO: ADD/ REMOVE CREDIT AND TRANSACTION METHODS!!!

    public CreditCard getCreditCard() {
        return null;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }

    //    public ArrayList<MovieCredit> getUserCredit() {
//        return userCredit;
//    }

//    public void setUserCredit(ArrayList<MovieCredit> userCredit) {
//        this.userCredit = userCredit;
//    }

    public ArrayList<Transaction> getPreviousPurchases() {
        return previousPurchases;
    }

    public void setPreviousPurchases(ArrayList<Transaction> previousPurchases) {
        this.previousPurchases = previousPurchases;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                '}' + '\n';
    }

    public void retrieveCreditCard() throws SQLException {

    }
}
