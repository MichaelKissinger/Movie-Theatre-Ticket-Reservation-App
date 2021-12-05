package controller;

import model.Database;
import model.Movie;
import model.Showing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MovieController {

    ArrayList<Movie> movieList;
    ShowingController showingController;


    public MovieController() throws SQLException {
        // PULL ALL MOVIES INTO MOVIE LIST
        showingController = new ShowingController();
        Database myDatabase = new Database();
        movieList = myDatabase.getMovieDB();
    }

    public String displayAllMovies(){
        StringBuilder movies = new StringBuilder();

        for(Movie movie: movieList){
            movies.append(movie.getTitle()).append("\n").append(movie.getDescription()).append("\n\n");
        }

        return movies.toString();
    }

    public String getMovieByTitle(String search) {
        for(Movie movie: movieList){
            if(search.equals(movie.getTitle())){
                return showingController.displayAllShowings(movie);
            }
        }
        return "Movie not found!";
    }


    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
}
