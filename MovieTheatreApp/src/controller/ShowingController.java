package controller;

import model.Movie;
import model.Showing;

import java.util.ArrayList;

public class ShowingController {

    public ShowingController() {
    }

    public String displayAllShowings(Movie movie) {
        ArrayList<Showing> showingList = movie.getShowings();
        StringBuilder showings = new StringBuilder();
        showings.append(movie.getTitle()).append("\n\n");

        for(Showing show: showingList){
            showings.append("Show ID: ").append(show.getShowingId()).append("\n")
                    .append("Show Time: ").append(show.getShowTime()).append("\n")
                    .append("Ticket Price: ").append(show.getTicketPrice()).append("\n\n");
        }
        return showings.toString();
    }



}
