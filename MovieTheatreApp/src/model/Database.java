package model;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Database {

    private static ArrayList<Movie> movieDB;
    private static Seat[][] seatDB;
    private static ArrayList<User> userDB;
    private static ArrayList<RegisteredUser> registeredUserDB;


//    private JDBCConnect myJDBC;

    public Database() throws SQLException {
        myJDBC = new JDBCConnect();
        myJDBC.createConnection();
        initializeMovies();
        initializeUsers();
        initializeRegisteredUsers();
    }

    private static JDBCConnect myJDBC;

//    private Database() throws SQLException { }

    private static void connectJDBC() {
        if(myJDBC == null){
            myJDBC = new JDBCConnect();
            myJDBC.createConnection();
        }

    }

    private static void initializeMovies() throws SQLException {
        movieDB = myJDBC.movieSetStatement();
    }

    private static void initializeUsers() throws SQLException {
        userDB = myJDBC.userSetStatement();
    }

    private static void initializeRegisteredUsers() throws SQLException {
        registeredUserDB = myJDBC.registeredUserSetStatement();
    }

    public static ArrayList<Movie> getMovieDB() throws SQLException {
        connectJDBC();
        if(movieDB == null){
            initializeMovies();
        }
        return movieDB;
    }

    public static ArrayList<User> getUserDB() throws SQLException {
        connectJDBC();
        if(userDB == null){
            initializeUsers();
        }
        return userDB;
    }

    public static ArrayList<RegisteredUser> getRegisteredUserDB() throws SQLException {
        connectJDBC();
        if(registeredUserDB == null){
            initializeRegisteredUsers();
        }
        return registeredUserDB;
    }

}
