package model;

import java.util.Date;

public class RegisteredUser extends User {
    private String name;
    private String address;
    private Card paymentOption;
    private String password;
    private Boolean activeStatus;
    private Date lastPaymentDate;

    public RegisteredUser(int userId, String email, String address, String password)
    {
        super(userId, email);
        setAddress(address);
        setPassword(password);

    }

    // TO-DO: ADD ADD CARD, MAKE PAYMENT - > ACTIVATE/UPDATE LAST PAYMENT!!!

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Card getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(Card paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }
}
