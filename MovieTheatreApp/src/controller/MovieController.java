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

//        movieList = new ArrayList<Movie>();
//        movieList.add(new Movie(1, "Starwars", "starwars"));
//        movieList.add(new Movie(2, "James Bond", "007"));
//        movieList.add(new Movie(3, "Spiderman", "spider"));
//        Date date = new Date();
//        for(Movie movie: movieList) {
//            movie.addShowing(new Showing(1, movie.getMovieId(), date, 10.75));
//            movie.addShowing(new Showing(2, movie.getMovieId(), date, 10.75));
//            movie.addShowing(new Showing(3, movie.getMovieId(), date, 10.75));
//        }
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
