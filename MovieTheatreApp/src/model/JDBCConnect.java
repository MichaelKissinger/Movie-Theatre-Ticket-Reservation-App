package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class JDBCConnect {

    private Connection dbConnect;

    public void createConnection() {
        try {
            //You to enter your own SQL  username and password below to make this work!!

            // dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "Katana123!");
            // dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "kou19980126");
            //  dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "Teck5Taillight!");
            // dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "Hydrogen97!");
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

    public ArrayList<Showing> allShowingsSetStatement() throws SQLException {
        ArrayList<Showing> showingList = new ArrayList<Showing>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM SHOWING;");

            while (results.next()) {
                int movieId = results.getInt("MovieID");
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
                int transactionID = results.getInt("TransactionID");

                Seat mySeat = new Seat(showingId, rownum, colnum, transactionID);
                seatList.add(mySeat);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatList;
    }

    public ArrayList<Seat> allSeatsSetStatement() throws SQLException {
        ArrayList<Seat> seatList = new ArrayList<Seat>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM SEATS;");

            while (results.next()) {
                int showingId = results.getInt("ShowingID");
                String rownum = results.getString("rownum");
                int colnum = results.getInt("colnum");
                int transactionID = results.getInt("TransactionID");

                Seat mySeat = new Seat(showingId, rownum, colnum, transactionID);
                seatList.add(mySeat);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatList;
    }

    public ArrayList<MovieCredit> creditSetStatement(int userId) throws SQLException {
        ArrayList<MovieCredit> creditList = new ArrayList<MovieCredit>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM MovieCredits WHERE UserID = \"" + userId + "\";");

            while (results.next()) {
                int movieCreditId = results.getInt("CreditID");
                String creditCode = results.getString("CreditCode");
                Date expiryDate = results.getDate("ExpiryDate");
                double amount = results.getDouble("Amount");

                MovieCredit myMovieCredit = new MovieCredit(movieCreditId, creditCode, expiryDate,
                amount, userId);
                creditList.add(myMovieCredit);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditList;
    }

    public void addUserToDB(String email, Boolean isRegistered,
                            String name, String address, String password,
                            Boolean activeStatus, Date lastPaymentDate) throws SQLException {
        String query = "INSERT INTO USER " +
                "(IsRegistered, Name, Address, Email, Password, ActiveStatus, LastPaymentDate) " +
                "values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = dbConnect.prepareStatement(query);
        preparedStmt.setBoolean(1, isRegistered);
        preparedStmt.setString (2, name);
        preparedStmt.setString (3, address);
        preparedStmt.setString (4, email);
        preparedStmt.setString (5, password);
        preparedStmt.setBoolean (6, activeStatus);
        preparedStmt.setDate (7, (java.sql.Date) lastPaymentDate);

        // execute the prepared statement
        preparedStmt.execute();
    }

    public void updateRegUserInDB(int userId, Boolean isRegistered,
                            String name, String address, String password,
                            Boolean activeStatus, Date lastPaymentDate) throws SQLException {
        String query = "UPDATE USER SET IsRegistered = ?, Name = ?, Address = ?, Password = ?, ActiveStatus = ?, LastPaymentDate = ? WHERE UserID = ?";
        PreparedStatement preparedStmt = dbConnect.prepareStatement(query);
        preparedStmt.setBoolean(1, isRegistered);
        preparedStmt.setString (2, name);
        preparedStmt.setString (3, address);
        preparedStmt.setString (4, password);
        preparedStmt.setBoolean (5, activeStatus);
        preparedStmt.setDate (6, (java.sql.Date) lastPaymentDate);
        preparedStmt.setInt (7, userId);

        // execute the prepared statement
        preparedStmt.execute();
    }

    public void addTransactionToDB(User user, double totalCost, CreditCard creditCard) throws SQLException {
        String query = "INSERT INTO TRANSACTION " +
                "(UserID, Cost, PurchaseDate, CardID) " +
                "values (?, ?, ?, ?)";

        //SQl Date
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        PreparedStatement preparedStmt = dbConnect.prepareStatement(query);
        preparedStmt.setInt(1, user.getUserId());
        preparedStmt.setFloat (2, (float)totalCost);
        preparedStmt.setDate (3, sqlDate);
        preparedStmt.setInt (4, creditCard.getCardId());

        // execute the prepared statement
        preparedStmt.execute();
    }

    public void addCreditCardToDB(User user, String cardHolderName, String cardNumber, int expiryMonth, int expiryYear, int cvv) throws SQLException {
        String query = "INSERT INTO CREDITCARD " +
                "(UserID, CardHolderName, cardNumber, expiryMonth, expiryYear, cvv) " +
                "values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = dbConnect.prepareStatement(query);
        preparedStmt.setInt(1, user.getUserId());
        preparedStmt.setString(2, cardHolderName);
        preparedStmt.setString(3, cardNumber);
        preparedStmt.setInt(4, expiryMonth);
        preparedStmt.setInt(5, expiryYear);
        preparedStmt.setInt(6, cvv);

        // execute the prepared statement
        preparedStmt.execute();

    }

    public ArrayList<Transaction> transactionSetStatement() throws SQLException {
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM TRANSACTION;");

            while (results.next()) {

                int transactionId  = results.getInt("TransactionID");
                int userID = results.getInt("UserID");
                double totalCost = results.getDouble("Cost");
                Date purchaseDate = results.getDate("PurchaseDate");
                int cardID = results.getInt("CardID");
                int showingId = results.getInt("ShowingId");

                Transaction myTransaction = new Transaction(transactionId, userID,
                        totalCost, purchaseDate, cardID, showingId);
                transactionList.add(myTransaction);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionList;
    }
}

