package model;

import java.util.Date;

public class RegisteredUser extends User {
    private String name;
    private String address;
    private Card paymentOption;
    private String password;
    private Boolean activeStatus;
    private Date lastPaymentDate;
}
