package model;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Database {

    private static ArrayList<Movie> movieDB;
    private static ArrayList<Seat> seatDB;
    private static ArrayList<User> userDB;
    private static ArrayList<RegisteredUser> registeredUserDB;
    private static ArrayList<Transaction> transactionDB;
    private static ArrayList<Showing> showingDB;

//    public Database() throws SQLException {
//        myJDBC = new JDBCConnect();
//        myJDBC.createConnection();
//        initializeMovies();
//        initializeUsers();
//        initializeRegisteredUsers();
//    }

    private static JDBCConnect myJDBC;

    private Database() throws SQLException { }

    private static void connectJDBC() {
        if(myJDBC == null){
            myJDBC = new JDBCConnect();
            myJDBC.createConnection();
        }

    }

    private static void initializeSeats() throws SQLException {
        seatDB = myJDBC.allSeatsSetStatement();
    }

    private static void initializeTransactions() throws SQLException {
        transactionDB = myJDBC.transactionSetStatement();
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

    private static void initializeShowings() throws SQLException {
        showingDB = myJDBC.allShowingsSetStatement();
    }

    public static ArrayList<Movie> getMovieDB() throws SQLException {
        connectJDBC();
        initializeMovies();
        return movieDB;
    }

    public static ArrayList<Transaction> getTransactionDB() throws SQLException {
        connectJDBC();
        initializeTransactions();
        return transactionDB;
    }

    public static ArrayList<Seat> getSeatDB() throws SQLException {
        connectJDBC();
        initializeSeats();
        return seatDB;
    }

    public static ArrayList<User> getUserDB() throws SQLException {
        connectJDBC();
        initializeUsers();
        return userDB;
    }

    public static ArrayList<RegisteredUser> getRegisteredUserDB() throws SQLException {
        connectJDBC();
        initializeRegisteredUsers();
        return registeredUserDB;
    }

    public static ArrayList<Showing> getShowingDB() throws SQLException {
        connectJDBC();
        initializeShowings();
        return showingDB;
    }

    public static void addUser(String email) throws SQLException {
        connectJDBC();
        Boolean isRegistered = false;
        String name = "";
        String address = "";
        String password = "";
        Boolean activeStatus = false;
        Date lastPaymentDate = null;
        myJDBC.addUserToDB(email, isRegistered,
                name, address, password,
                activeStatus, lastPaymentDate);
        userDB = myJDBC.userSetStatement();
    }

    public static void registerUser(int userId, String name, String address, String password, Date lastPaymentDate)
            throws SQLException {
        connectJDBC();
        myJDBC.updateRegUserInDB(userId, true,
                name, address, password,
                true, lastPaymentDate);
        initializeRegisteredUsers();
    }

}
