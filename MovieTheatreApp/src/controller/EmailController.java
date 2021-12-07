package controller;

import model.User;
import model.Message;
import view.EmailView;
import javax.swing.*;
import java.sql.SQLException;


/**
 * EmailController class is used to control the email view.
 * It also connects to the model to pass all required information.
 */
public class EmailController
{
    private User user;
    private Message email;
    DatabaseController dbc;

    public EmailController(User user, DatabaseController dbc) throws SQLException {

        this.user = user;
        EmailView view = new EmailView(dbc.getUserMail(user));
        view.setVisible(true);
        view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        view.addBackButtonListener(e -> {
            try {
                TerminalController terminalController = new TerminalController(this.user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            view.setVisible(false);
        });

        view.addListSelectionListener(e -> {
            if (view.changingMessage())
            {
              view.set();
                try {
                    dbc.updateReadStatus(view.returnSelected());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


    }

}
