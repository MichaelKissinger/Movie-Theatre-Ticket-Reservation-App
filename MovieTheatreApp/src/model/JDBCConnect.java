//package model;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Date;
//
//public class JDBCConnect {
//
//    private Connection dbConnect;
//
//    public void createConnection() {
//        try {
//            //You to enter your own SQL  username and password below to make this work!!
//            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/MOVIESYSTEM", "root", "Katana123!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<Movie> movieSetStatement() throws SQLException {
//        ArrayList<Movie> movieList = new ArrayList<Movie>();
//        try {
//            Statement myStmt = dbConnect.createStatement();
//            ResultSet results = myStmt.executeQuery("SELECT * FROM MOVIE;");
//
//            while (results.next()) {
//                int movieId = results.getInt("MovieID");
//                String userName = results.getString("Title");
//                String password = results.getString("Synopsis");
//
//                Movie myMovie = new Movie(movieId, userName, password);
//                movieList.add(myMovie);
//            }
//            myStmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return movieList;
//    }
//
//    public ArrayList<Showing> showingSetStatement(int movieId) throws SQLException {
//        ArrayList<Showing> showingList = new ArrayList<Showing>();
//        try {
//            Statement myStmt = dbConnect.createStatement();
//            ResultSet results = myStmt.executeQuery("SELECT * FROM SHOWING WHERE MovieID = \"" + movieId + "\";");
//
//            while (results.next()) {
//                int showingId = results.getInt("ShowingID");
//                Date showTime = results.getDate("ShowTime");
//                double ticketPrice = results.getDouble("TicketPrice");
//                int theatreId = results.getInt("TheatreID");
//
//                Showing myShowing = new Showing(showingId, movieId, showTime, ticketPrice);
//                showingList.add(myShowing);
//            }
//            myStmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return showingList;
//    }
//
//
//
//}