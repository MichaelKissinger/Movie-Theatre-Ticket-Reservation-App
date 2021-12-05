package model;

import java.util.Calendar;
import java.util.Date;
public class MovieCredit
{
    // CONSIDER: make user able to pay with existing credit- checks credit list for a credit with sufficient funds for the payment at hand
    int movieCreditId;
    String creditCode;
    Date creationDate;
    Date expiryDate;
    double amount;

//    public MovieCredit(double amount)
//    {
//        setAmount(amount);
//        setCreationDate(new Date());
//        setCreditCode((int)Math.floor(Math.random()*1000000));
//        // MAKE IT +1 YEAR TODAY
////        setExpiryDate();
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(creationDate);
//        cal.add(Calendar.YEAR, 1);
//        setExpiryDate(cal.getTime());
//
//    }

    public int getMovieCreditId() {
        return movieCreditId;
    }

    public void setMovieCreditId(int movieCreditId) {
        this.movieCreditId = movieCreditId;
    }

    public int getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(int creditCode) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
