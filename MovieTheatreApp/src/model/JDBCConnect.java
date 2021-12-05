package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class JDBCConnect {

    private Connection dbConnect;

    public void createConnection() {
        try {
            //You to enter your own SQL  username and password below to make this work!!
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "Teck5Taillight!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Movie> movieSetStatement() throws SQLException {
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM MOVIE;");

            while (results.next()) {
                int movieId = results.getInt("MovieID");
                String userName = results.getString("Title");
                String password = results.getString("Synopsis");

                Movie myMovie = new Movie(movieId, userName, password);
                movieList.add(myMovie);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    public ArrayList<Showing> showingSetStatement(int movieId) throws SQLException {
        ArrayList<Showing> showingList = new ArrayList<Showing>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM SHOWING WHERE MovieID = \"" + movieId + "\";");

            while (results.next()) {
                int showingId = results.getInt("ShowingID");
                Date showTime = results.getDate("ShowTime");
                double ticketPrice = results.getDouble("TicketPrice");
                int theatreId = results.getInt("TheatreID");

                Showing myShowing = new Showing(showingId, movieId, showTime, ticketPrice, theatreId);
                showingList.add(myShowing);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showingList;
    }

    public ArrayList<User> userSetStatement() throws SQLException {
        ArrayList<User> userList = new ArrayList<User>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM USER");

            while (results.next()) {
                int userId = results.getInt("UserId");
                String email = results.getString("Email");
                Boolean isRegistered = results.getBoolean("IsRegistered");
                User myUser = new User(userId, email, isRegistered);
                userList.add(myUser);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public ArrayList<RegisteredUser> registeredUserSetStatement() throws SQLException {
        ArrayList<RegisteredUser> registeredUserList = new ArrayList<RegisteredUser>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM USER");

            while (results.next()) {
                int userId = results.getInt("UserId");
                String email = results.getString("Email");
                Boolean isRegistered = results.getBoolean("IsRegistered");
                String name = results.getString("Name");
                String address = results.getString("Address");
                String password = results.getString("Password");
                Boolean activeStatus = results.getBoolean("ActiveStatus");
                Date lastPaymentDate = results.getDate("LastPaymentDate");

                RegisteredUser myUser = new RegisteredUser(userId, email, isRegistered, name,
                        address, password,
                        activeStatus, lastPaymentDate);
                registeredUserList.add(myUser);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredUserList;
    }

    public ArrayList<Seat> seatSetStatement(int showingId) throws SQLException {
        ArrayList<Seat> seatList = new ArrayList<Seat>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM SEATS WHERE ShowingID = \"" + showingId + "\";");

            while (results.next()) {
                String rownum = results.getString("rownum");
                int colnum = results.getInt("colnum");
                Boolean reserved = results.getBoolean("reserved");

                Seat mySeat = new Seat(showingId, rownum, colnum, reserved);
                seatList.add(mySeat);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatList;
    }
}

