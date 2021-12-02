package model;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

public class Database {

    private static ArrayList<Movie> movieDB;
    private static Seat[][] seatDB;
    private static ArrayList<User> RegUserDB;

    private Database() { }

    public static ArrayList<Movie> getMovieDB() {

        movieDB = new ArrayList<Movie>();

        movieDB.add(new Movie("Starwars", "A long time ago..", 1));
        movieDB.add(new Movie("James Bond", "007", 2));
        movieDB.add(new Movie("Fast and Furious", "Cars and guns", 3));
        movieDB.add(new Movie("Step Brothers", "Brothers of step", 4));
        movieDB.add(new Movie("Ghostbusters", "spooky", 5));

        for(Movie movie: movieDB) {
            movie.addShowing(new Showing(1, new Date(2021, 12, 01, 17, 30), 10.75), movie, new Theatre());
            movie.addShowing(new Showing(1, new Date(2021, 12, 01, 20, 00), 10.75), movie, new Theatre());
            movie.addShowing(new Showing(1, new Date(2021, 12, 02, 17, 30), 10.75), movie, new Theatre());
            movie.addShowing(new Showing(1, new Date(2021, 12, 02, 20, 00), 10.75), movie, new Theatre());
        }

        return movieDB;
    }

    public static Seat[][] getSeatDB() {

        seatDB = new Seat[5][5];

        for(int i = 0; i < seatDB.length; i++){
            for(int j = 0; j < seatDB[i].length; j++){
                seatDB[i][j] = new Seat((char)(65+i), j);
            }
        }

        return seatDB;
    }

    public static ArrayList<User> getRegUserDB() {
        RegUserDB = new ArrayList<User>();


        return RegUserDB;
    }


}
