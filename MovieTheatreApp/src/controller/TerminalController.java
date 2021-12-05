package controller;

import model.User;
import view.*;

import javax.swing.*;
import java.sql.SQLException;

public class TerminalController {
    TerminalView terminalView;
    MovieController movieController;
    User user;

    public TerminalController(User user) throws SQLException {
        this.user = user;
        terminalView = new TerminalView();
        movieController = new MovieController();
        // Shows the GUI
        terminalView.setVisible(true);
        terminalView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        terminalView.addSearchMovieListener(e -> {
            SelectMovieController selectMovieController = new SelectMovieController(user, movieController);
            terminalView.setFlag("Search");
            terminalView.clearDisplay();
            terminalView.addText(movieController.displayAllMovies());
        });

        terminalView.addBuyMovieTicketListener(e -> {
            SelectMovieController selectMovieController = new SelectMovieController(user, movieController);
            terminalView.setVisible(false);
        });

        terminalView.addCancelTicketListener(e->{

        });

        terminalView.addRegisterListener(e->{

        });

        terminalView.addViewEmailListener(e->{

        });

        terminalView.addEnterButtonListener(e -> {
            String flag = terminalView.getFlag();
            switch (flag){
                case "Search": {
                    String movieTitle = terminalView.getStringInput();
                    String showings = movieController.getMovieByTitle(movieTitle);
                    terminalView.clearDisplay();
                    terminalView.addText(showings);
                    break;
                }
                case "Select Movie": {
                    String movieTitle = terminalView.getStringInput();
                    String showings = movieController.getMovieByTitle(movieTitle);
                    terminalView.clearDisplay();
                    terminalView.addText("Enter the Showing Id of the Showing you would like to see: \n");
                    terminalView.addText(showings);
                    terminalView.setFlag("Select Showing");
                    break;
                }
                case "Select Showing": {

                    String showingId = terminalView.getStringInput();

                    // TO-DO: CHECK VALID SHOWING ID

                    SeatView seatView = new SeatView();
                    // Shows the GUI
                    seatView.setVisible(true);
                    seatView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    terminalView.setVisible(false);
                    break;
                }

            }
        });
    }



















}
