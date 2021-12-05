package controller;

import model.Movie;
import model.Showing;
import model.User;
import view.SelectShowingView;

import javax.swing.*;

public class SelectShowingController {

    private User user;
    private Movie movie;
    private Showing showing;

    public SelectShowingController(User user, Movie movie) {
        this.user = user;
        this.movie = movie;

        SelectShowingView selectShowingView = new SelectShowingView(movie.getShowings());
        selectShowingView.setVisible(true);
        selectShowingView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectShowingView.addBackButtonListener(e -> {
            TerminalController terminalController = new TerminalController(this.user);
            selectShowingView.setVisible(false);
        });

        selectShowingView.addProceedButtonListener(e -> {
            int index = selectShowingView.getListIndex();
            showing = movie.getShowings().get(index);
            SelectedSeatController selectedSeatController = new SelectedSeatController(user, showing);
            selectShowingView.setVisible(false);


        });

    }


}
