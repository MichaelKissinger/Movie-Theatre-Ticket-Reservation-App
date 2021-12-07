package controller;

import model.User;
import model.Email;
import view.EmailView;
import javax.swing.*;
import java.sql.SQLException;


public class EmailController
{
    private User user;
    private Email email;
    DatabaseController dbc;

    public EmailController(User user, DatabaseController dbc) {

        this.user = user;
        //EmailView view = new EmailView(dbc.getEmail)
    }

}
