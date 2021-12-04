package model;

import java.util.Date;

public class MovieCredit
{
    // CONSIDER: make user able to pay with existing credit- checks credit list for a credit with sufficient funds for the payment at hand
    int movieCreditId;
    String creditCode;
    Date creationDate;
    Date expiryDate;
    double amount;

    public MovieCredit(double amount)
    {
        setAmount(amount);

        // MAKE IT +1 YEAR TODAY
        setExpiryDate();
    }

    // TO-DO: METHODS FOR ASSIGNING CREDIT CODE AND ID!!!


    public int getMovieCreditId() {
        return movieCreditId;
    }

    public void setMovieCreditId(int movieCreditId) {
        this.movieCreditId = movieCreditId;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
