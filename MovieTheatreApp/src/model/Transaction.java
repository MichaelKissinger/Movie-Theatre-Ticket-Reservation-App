package model;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    int transactionId;
    User user;
    ArrayList<Ticket> tickets;
    double totalCost;
    Date purchaseDate;
    Card paymentCard;
}
