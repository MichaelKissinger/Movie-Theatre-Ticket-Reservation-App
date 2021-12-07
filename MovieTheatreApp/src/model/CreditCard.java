package model;

import java.sql.SQLException;

public class CreditCard {
    int cardId;
    int userId;
    String cardHolderName;
    String cardNumber;
    int expiryMonth;
    int expiryYear;
    int cvv;
    JDBCConnect myJDBC;

    // For already existing cards
    public CreditCard(int cardId, int userId, String name, String number, int expMonth, int expYear, int cvv)
    {
        setCardId(cardId);
        setUserId(userId);
        setCardHolderName(name);
        setCardNumber(number);
        setExpiryMonth(expMonth);
        setExpiryYear(expYear);
        setCvv(cvv);
    }

    // for new credit cards
    public CreditCard(int userId, String name, String number, int expMonth, int expYear, int cvv) throws SQLException {
        setUserId(userId);
        setCardHolderName(name);
        setCardNumber(number);
        setExpiryMonth(expMonth);
        setExpiryYear(expYear);
        setCvv(cvv);

        myJDBC = new JDBCConnect();
        myJDBC.createConnection();
        this.cardId = myJDBC.addCreditCardToDB(userId, cardHolderName, cardNumber, expiryMonth, expiryYear, cvv);

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber=" + cardNumber +
                ", expiryMonth=" + expiryMonth +
                ", expiryYear=" + expiryYear +
                ", cvv=" + cvv +
                '}';
    }
}
