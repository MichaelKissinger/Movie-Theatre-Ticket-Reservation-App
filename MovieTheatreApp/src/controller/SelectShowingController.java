package controller;

import model.Movie;
import model.Showing;
import model.User;
import view.SelectShowingView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * SelectShowingController class is used to control the showings view.
 * It also connects to the model to pass all required information.
 */
public class SelectShowingController {

    private User user;
    private Movie movie;
    private Showing showing;
    private ArrayList<Showing> userShowingList;

    public SelectShowingController(User user, Movie movie) {
        this.user = user;
        this.movie = movie;

        if(user.getRegistered()){
            userShowingList = movie.getShowings();
        }
        else {
            userShowingList = new ArrayList<Showing>();
            for(Showing show: movie.getShowings()){
                if(show.isAvailableToPublic()){
                    userShowingList.add(show);
                }
            }

        }

        SelectShowingView selectShowingView = new SelectShowingView(userShowingList);
        selectShowingView.setVisible(true);
        selectShowingView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectShowingView.addBackButtonListener(e -> {
            try {
                TerminalController terminalController = new TerminalController(this.user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            selectShowingView.setVisible(false);
        });

        selectShowingView.addProceedButtonListener(e -> {
            int index = selectShowingView.getListIndex();
            showing = userShowingList.get(index);
            SelectedSeatController selectedSeatController = new SelectedSeatController(user, showing);
            selectShowingView.setVisible(false);


        });

    }


}
