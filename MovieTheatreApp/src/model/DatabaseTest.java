package model;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * DatabaseTest is only a sandbox class for testing various functionality
 * in the database.
 */
public class DatabaseTest {

    public static void main(String[] args) throws SQLException {
        Database database = Database.getDatabase();


//        System.out.println(Database.getMovieDB());
//
//        for (Movie m: Database.getMovieDB()) {
//            System.out.println(m.getShowings());
//        }
//
//        System.out.println(Database.getUserDB());
//
//        System.out.println(Database.getRegisteredUserDB());

//        String email = "mike@hotmail.com";
//
//        User ordinaryUser = LoginChecker.AuthenticateOrdinaryUser(email);
//        System.out.println(ordinaryUser);
////
//        String name = "Michael";
//        String address = "1234 Fake street NW";
//        String password = "SoSneaky123";
//
//        Database.registerUser(ordinaryUser.getUserId(), name, address, password, new Date(System.currentTimeMillis()));
//        RegisteredUser regUser = LoginChecker.AuthenticateRegisteredUser(email, password);
////
//        System.out.println(regUser);

//        ArrayList<User> myUserDB = Database.getUserDB();
//
//            for (User u: Database.getUserDB()) {
//                if (u.getEmail().equals(email)){
//                    System.out.println(u);
//
//                } else {
//                    System.out.println("Does not Exist");
//
//                }
//            }

        JDBCConnect myJDBC = new JDBCConnect();
        myJDBC.createConnection();

//        int showingId = 1;
//
//        ArrayList<Seat> mySeats = myJDBC.allSeatsSetStatement();
//
//        System.out.println(mySeats);

//        ArrayList<Transaction> myTrans = Database.getTransactionDB();
//
//        System.out.println(myTrans + "\n");


//        System.out.println(database.getSeatDB());
//
//        myJDBC.updateSeatDB(4, "C", 2);
//
//        System.out.println(database.getSeatDB());

//        ArrayList<Movie> movies = database.getMovieDB();
//
//        System.out.println(movies);
//
//        for (Movie m: movies)
//        {
//            if (m.getMovieId() == showing.getMovieId())
//            {
//                title = m.getTitle();
//            }
//        }

//        int id = 1;
//        System.out.println(Database.getTransactionDB());
//
//        System.out.println(database.getSeatDB());
//
//
//        myJDBC.transactionsStatement(id);
//
//
//        System.out.println(Database.getTransactionDB());
//
//        System.out.println(database.getSeatDB());







    }
}
