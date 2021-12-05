package model;

public class CreditCard {
    int cardId;
    int userId;
    String cardHolderName;
    int cardNumber;
    int expiryMonth;
    int expiryYear;
    int cvv;

    public CreditCard(String name, int number, int expMonth, int expYear, int cvv)
    {
        setCardHolderName(name);
        setCardNumber(number);
        setExpiryMonth(expMonth);
        setExpiryYear(expYear);
        setCvv(cvv);
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

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
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
