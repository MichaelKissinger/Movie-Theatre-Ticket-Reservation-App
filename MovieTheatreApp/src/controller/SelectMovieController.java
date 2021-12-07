package controller;

import model.Movie;
import model.User;
import view.SelectMovieView;

import javax.swing.*;
import java.sql.SQLException;

/**
 * SelectMovieController class is used to control the select movie view.
 * It also connects to the model to pass all required information.
 */
public class SelectMovieController {
    private User user;
    private Movie movie;
    DatabaseController databaseController;

    public SelectMovieController(User user, DatabaseController databaseController) {

        this.user = user;

        SelectMovieView selectMovieView = new SelectMovieView(databaseController.getMovieList());
        selectMovieView.setVisible(true);
        selectMovieView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectMovieView.addBackButtonListener(e -> {
            try {
                TerminalController terminalController = new TerminalController(this.user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            selectMovieView.setVisible(false);
        });

        selectMovieView.addProceedButtonListener(e -> {
            int index = selectMovieView.getListIndex();
            movie = databaseController.getMovieList().get(index);
            SelectShowingController selectShowingController = new SelectShowingController(this.user, movie);
            selectMovieView.setVisible(false);
        });

    }
}
