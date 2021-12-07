package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class JDBCConnect {

    private Connection dbConnect;

    public void createConnection() {
        try {
            //You to enter your own SQL  username and password below to make this work!!

             dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "Katana123!");
            // dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "kou19980126");
            //  dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "Teck5Taillight!");
//             dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "Hydrogen97!");
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

    public int addTransactionToDB(User user, double totalCost, CreditCard creditCard, int showingId) throws SQLException {
        String query = "INSERT INTO TRANSACTION " +
                "(UserID, Cost, PurchaseDate, CardID, ShowingID) " +
                "values (?, ?, ?, ?, ?)";

        //SQl Date
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        PreparedStatement preparedStmt = dbConnect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setInt(1, user.getUserId());
        preparedStmt.setFloat (2, (float)totalCost);
        preparedStmt.setDate (3, sqlDate);
        preparedStmt.setInt (4, creditCard.getCardId());
        preparedStmt.setInt (5, showingId);

        // execute the prepared statement
        int affectedRows = preparedStmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating transaction failed, no rows affected.");
        }

        try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating transaction failed, no ID obtained.");
            }
        }
    }

    public int addCreditCardToDB(int userId, String cardHolderName, String cardNumber, int expiryMonth, int expiryYear, int cvv) throws SQLException {
        String query = "INSERT INTO CREDITCARD " +
                "(UserID, CardHolderName, cardNumber, expiryMonth, expiryYear, cvv) " +
                "values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = dbConnect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setInt(1, userId);
        preparedStmt.setString(2, cardHolderName);
        preparedStmt.setString(3, cardNumber);
        preparedStmt.setInt(4, expiryMonth);
        preparedStmt.setInt(5, expiryYear);
        preparedStmt.setInt(6, cvv);

        // execute the prepared statement
        int affectedRows = preparedStmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating creditCard failed, no rows affected.");
        }

        try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating creditCard failed, no ID obtained.");
            }
        }
    }

    public CreditCard getCreditCardByUserId(int userId) throws SQLException {
        CreditCard creditCard = null;
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM CREDITCARD WHERE UserID = \"" + userId + "\";");

            while (results.next()) {
                int cardId = results.getInt("CardID");
                String cardHolderName = results.getString("CardHolderName");
                String cardNumber = results.getString("cardNumber");
                int expiryMonth = results.getInt("expiryMonth");
                int expiryYear = results.getInt("expiryYear");
                int cvv = results.getInt("cvv");

                creditCard = new CreditCard(cardId, userId, cardHolderName, cardNumber, expiryMonth, expiryYear, cvv);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditCard;
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


    public void updateSeatDB(int showingId, String row, int col) throws SQLException {
        String query = "UPDATE SEATS SET TransactionID = ? WHERE ShowingID = \"" + showingId + "\" AND rownum = \"" + row + "\"AND colnum = \"" + col + "\";";
        PreparedStatement preparedStmt = dbConnect.prepareStatement(query);
        preparedStmt.setObject(1, null);
    }


    public void updateSeatTransactionId(int transactionId, int showingId, String row, int col) throws SQLException {
        String query = "UPDATE SEATS SET TransactionID = ? WHERE ShowingID = ? AND rownum = ? AND colnum = ?";
        PreparedStatement preparedStmt = dbConnect.prepareStatement(query);
        preparedStmt.setInt(1, transactionId);
        preparedStmt.setInt (2, showingId);
        preparedStmt.setString (3, row);
        preparedStmt.setInt (4, col);
        // execute the prepared statement
        preparedStmt.execute();
    }



    public void addMessageToDB(User user, String message, String subjectLine) throws SQLException {
        String query = "INSERT INTO MESSAGE " +
                "(userID, Message, SubjectLine, SentDate, ReadStatus) " +
                "values (?, ?, ?, ?, ?)";

        //SQl Date
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        PreparedStatement preparedStmt = dbConnect.prepareStatement(query);
        preparedStmt.setInt(1, user.getUserId());
        preparedStmt.setString (2, message);
        preparedStmt.setString (3, subjectLine);
        preparedStmt.setDate (4, sqlDate);
        preparedStmt.setBoolean (5, false);

        // execute the prepared statement
        preparedStmt.execute();
    }


    public int addMovieCreditToDB(String creditCode, Date expiryDate,
                                  double amount, int userId) throws SQLException {
        String query = "INSERT INTO MovieCredits (CreditCode, ExpiryDate, Amount, UserID) " +
                "values (?, ?, ?, ?)";

        PreparedStatement preparedStmt = dbConnect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, creditCode);
        preparedStmt.setDate(2, (java.sql.Date) expiryDate);
        preparedStmt.setDouble(3, amount);
        preparedStmt.setInt(4, userId);

        // execute the prepared statement
        int affectedRows = preparedStmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Adding movie credit to database failed, no rows affected.");
        }

        try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Adding movie credit to database failed, no ID obtained.");
            }
        }
    }


    public ArrayList<Message> userMessageSetStatement(User user) throws SQLException {
        ArrayList<Message> userMessageList = new ArrayList<Message>();
        int id = user.getUserId();
        try {
           String query = "SELECT * FROM MESSAGE WHERE UserID = ?";
            PreparedStatement myStmt = this.dbConnect.prepareStatement(query);
            myStmt.setInt(1, id);
            ResultSet results = myStmt.executeQuery();
            while (results.next()) {
                if (results.getInt("UserID") == id) {
                    Message foundMessage = new Message();
                    foundMessage.setUserID(id);
                    foundMessage.setMessageID(results.getInt("MessageID"));
                    foundMessage.setMessage(results.getString("Message"));
                    foundMessage.setSubjectLine(results.getString("SubjectLine"));
                    foundMessage.setSentDate(results.getDate("SentDate"));
                    foundMessage.setReadStatus(results.getBoolean("ReadStatus"));
                    userMessageList.add(foundMessage);
                }
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userMessageList;
    }

    public void updateMessage(int messageId) throws SQLException {
        String query = "UPDATE MESSAGE SET ReadStatus = ? WHERE MessageID = ?";
        PreparedStatement myStmt = dbConnect.prepareStatement(query);
        myStmt.setBoolean(1, true);
        myStmt.setInt(2, messageId);

        // execute the prepared statement
        myStmt.execute();

    }

}

