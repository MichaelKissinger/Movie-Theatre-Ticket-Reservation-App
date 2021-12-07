package model;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseTest {

    public static void main(String[] args) throws SQLException {
//        Database myDatabase = new Database();


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

        System.out.println(Database.getSeatDB());

        myJDBC.updateSeatDB(4, "C", 1);

        System.out.println(Database.getSeatDB());






    }
}
