package model;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Database {

    private static ArrayList<Movie> movieDB = new ArrayList<Movie>();
    private static Seat[][] seatDB;
    private static ArrayList<User> userDB;
    private static ArrayList<RegisteredUser> registeredUserDB;
    private static Date date = new Date();

    private JDBCConnect myJDBC;

    public Database() throws SQLException {
        myJDBC = new JDBCConnect();
        myJDBC.createConnection();
        initializeMovies();
        initializeUsers();
        initializeRegisteredUsers();
    }

    public void initializeMovies() throws SQLException {
        movieDB = myJDBC.movieSetStatement();
    }

    public void initializeUsers() throws SQLException {
        userDB = myJDBC.userSetStatement();
    }

    public void initializeRegisteredUsers() throws SQLException {
        registeredUserDB = myJDBC.registeredUserSetStatement();
    }

    public ArrayList<Movie> getMovieDB() {
        return movieDB;
    }

    public static void setMovieDB(ArrayList<Movie> movieDB) {
        Database.movieDB = movieDB;
    }

    public static ArrayList<User> getUserDB() {
        return userDB;
    }

    public static ArrayList<RegisteredUser> getRegisteredUserDB() {
        return registeredUserDB;
    }

//    public static ArrayList<Movie> loadMovies()
//    {
//        if ( movieDB == null)
//        {
//            Database.getMovieDB();
//        }
//        return movieDB;
//    }

//    public static void getMovieDB() {
//
//        //movieDB = new ArrayList<Movie>();
//        movieDB.add(new Movie("Starwars", "A long time ago..", 1));
//        movieDB.add(new Movie("James Bond", "007", 2));
//        movieDB.add(new Movie("Fast and Furious", "Cars and guns", 3));
//        movieDB.add(new Movie("Step Brothers", "Brothers of step", 4));
//        movieDB.add(new Movie("Ghostbusters", "spooky", 5));
//
//        for(Movie movie: movieDB) {
//            movie.addShowing(new Showing(1, date, 10.75, movie, new Theatre(1)));
//            movie.addShowing(new Showing(1, date, 10.75, movie, new Theatre(1)));
//            movie.addShowing(new Showing(1, date, 10.75, movie, new Theatre(1)));
//            movie.addShowing(new Showing(1, date, 10.75, movie, new Theatre(1)));
//        }
//    }
//
//    public static Seat[][] getSeatDB() {
//
//        seatDB = new Seat[5][5];
//
//        for(int i = 0; i < seatDB.length; i++){
//            for(int j = 0; j < seatDB[i].length; j++){
//                seatDB[i][j] = new Seat((char)(65+i), j);
//            }
//        }
//
//        return seatDB;
//    }
//
//    public static ArrayList<User> getRegUserDB() {
//        RegUserDB = new ArrayList<User>();
//
//        return RegUserDB;
//    }


}
