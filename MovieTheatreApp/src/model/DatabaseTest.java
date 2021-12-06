package model;

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

        String email = "nonregistereduser@ucalgary.ca";

        ArrayList<User> myUserDB = Database.getUserDB();

            for (User u: Database.getUserDB()) {
                if (u.getEmail().equals(email)){
                    System.out.println(u);

                } else {
                    System.out.println("Does not Exist");

                }
            }





    }
}
