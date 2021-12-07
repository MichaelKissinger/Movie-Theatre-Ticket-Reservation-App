package controller;

import model.User;
import view.*;

import javax.swing.*;
import java.sql.SQLException;

public class TerminalController {
    TerminalView terminalView;
    DatabaseController databaseController;
    User user;

    public TerminalController(User user) throws SQLException {
        this.user = user;
        terminalView = new TerminalView();
        databaseController = new DatabaseController();
        // Shows the GUI
        terminalView.setVisible(true);
        terminalView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        terminalView.addSearchMovieListener(e -> {
            terminalView.setFlag("Search");
            terminalView.clearDisplay();
            terminalView.addText("Search for a movie and press enter: \n\n");
            terminalView.addText(databaseController.displayAllMovies());
        });

        terminalView.addBuyMovieTicketListener(e -> {
            SelectMovieController selectMovieController = new SelectMovieController(user, databaseController);
            terminalView.setVisible(false);
        });

        terminalView.addCancelTicketListener(e->{
            try{
                terminalView.setVisible(false);
            SelectTransactionController selectTransactionController =
                    new SelectTransactionController(user);}
            catch(NullPointerException err){
                terminalView.displayErrorMessage("There are no tickets under your email");
            }

        });

        terminalView.addRegisterListener(e->{
            if (user.getRegistered()){
                terminalView.displayErrorMessage("You are already registered");
            }else{
            RegisterController registerController = new RegisterController(user);
            terminalView.setVisible(false);
            }


        });

        terminalView.addViewEmailListener(e->{

        });

        terminalView.addEnterButtonListener(e -> {
            String flag = terminalView.getFlag();

            switch(flag){
                case "Search": {
                    String search = terminalView.getStringInput();
                    terminalView.clearDisplay();
                    terminalView.addText(databaseController.displayMovieShowingsByTitle(search));
                }

                case "" : {

                }
            }

        });
    }



















}
