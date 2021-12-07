package model;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Database {

    private static Database database;
    private ArrayList<Movie> movieDB;
    private ArrayList<Seat> seatDB;
    private ArrayList<User> userDB;
    private ArrayList<RegisteredUser> registeredUserDB;
    private ArrayList<Transaction> transactionDB;
    private ArrayList<Showing> showingDB;
    private JDBCConnect myJDBC;


    private Database() throws SQLException {
        myJDBC = new JDBCConnect();
        myJDBC.createConnection();
    }

    public static Database getDatabase() throws SQLException {
        if(database == null){
            database = new Database();
        }
        return database;
    }

    private void initializeSeats() throws SQLException {
        seatDB = myJDBC.allSeatsSetStatement();
    }

    private void initializeTransactions() throws SQLException {
        transactionDB = myJDBC.transactionSetStatement();
    }

    private void initializeMovies() throws SQLException {
        movieDB = myJDBC.movieSetStatement();
    }

    private void initializeUsers() throws SQLException {
        userDB = myJDBC.userSetStatement();
    }

    private void initializeRegisteredUsers() throws SQLException {
        registeredUserDB = myJDBC.registeredUserSetStatement();
    }

    private void initializeShowings() throws SQLException {
        showingDB = myJDBC.allShowingsSetStatement();
    }

    public ArrayList<Movie> getMovieDB() throws SQLException {
        initializeMovies();
        return movieDB;
    }

    public ArrayList<Transaction> getTransactionDB() throws SQLException {
        initializeTransactions();
        return transactionDB;
    }

    public ArrayList<Seat> getSeatDB() throws SQLException {
        initializeSeats();
        return seatDB;
    }

    public ArrayList<User> getUserDB() throws SQLException {
        initializeUsers();
        return userDB;
    }

    public ArrayList<RegisteredUser> getRegisteredUserDB() throws SQLException {;
        initializeRegisteredUsers();
        return registeredUserDB;
    }

    public ArrayList<Showing> getShowingDB() throws SQLException {
        initializeShowings();
        return showingDB;
    }

    public void addUser(String email) throws SQLException {
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

    public void registerUser(int userId, String name, String address, String password, Date lastPaymentDate)
            throws SQLException {
        myJDBC.updateRegUserInDB(userId, true,
                name, address, password,
                true, lastPaymentDate);
        initializeRegisteredUsers();
    }

}
