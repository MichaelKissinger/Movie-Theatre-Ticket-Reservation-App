package model;

import java.util.Calendar;
import java.util.Date;
public class MovieCredit
{
    // CONSIDER: make user able to pay with existing credit- checks credit list for a credit with sufficient funds for the payment at hand
    int movieCreditId;
    String creditCode;
    Date expiryDate;
    double amount;
    int userId;

    public MovieCredit(int movieCreditId, String creditCode, Date expiryDate,
                       double amount, int userId) {
        this.movieCreditId = movieCreditId;
        this.creditCode = creditCode;
        this.expiryDate = expiryDate;
        this.amount = amount;
        this.userId = userId;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MovieCredit{" +
                "movieCreditId=" + movieCreditId +
                ", creditCode='" + creditCode + '\'' +
                ", expiryDate=" + expiryDate +
                ", amount=" + amount +
                ", userId=" + userId +
                '}';
    }
}
