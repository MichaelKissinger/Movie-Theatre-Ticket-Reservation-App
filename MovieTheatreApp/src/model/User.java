package model;

import java.util.ArrayList;

public class User
{
    protected int userId;
    protected String email;
    protected ArrayList<MovieCredit> userCredit;
    protected ArrayList<Transaction> previousPurchases;


    public User(int userId, String email) {
        setUserId(userId);
        setEmail(email);
        previousPurchases = new ArrayList<Transaction>();
        userCredit = new ArrayList<MovieCredit>();
    }

    public void initializeUserCredits() {

    }

    // TO_DO: ADD/ REMOVE CREDIT AND TRANSACTION METHODS!!!

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

    public ArrayList<MovieCredit> getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(ArrayList<MovieCredit> userCredit) {
        this.userCredit = userCredit;
    }

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
}
