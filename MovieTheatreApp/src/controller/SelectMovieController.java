package controller;

import model.Movie;
import model.User;
import view.SelectMovieView;
import view.SelectShowingView;

import javax.swing.*;
import java.sql.SQLException;

public class SelectMovieController {
    private User user;
    private Movie movie;
    MovieController movieController;

    public SelectMovieController(User user, MovieController movieController) {

        this.user = user;

        SelectMovieView selectMovieView = new SelectMovieView(movieController.getMovieList());
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
            movie = movieController.getMovieList().get(index);
            SelectShowingController selectShowingController = new SelectShowingController(this.user, movie);
            selectMovieView.setVisible(false);
        });

    }
}
