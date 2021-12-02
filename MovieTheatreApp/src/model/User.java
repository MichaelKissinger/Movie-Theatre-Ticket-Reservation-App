package model;

import java.util.ArrayList;

public class User {

    protected int userId;
    protected String email;
    protected ArrayList<MovieCredit> userCredit;
    protected ArrayList<Transaction> previousPurchases;
}
