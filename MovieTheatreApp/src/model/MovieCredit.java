package model;

import java.util.Date;

public class MovieCredit
{
    int movieCreditId;
    String creditCode;
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
