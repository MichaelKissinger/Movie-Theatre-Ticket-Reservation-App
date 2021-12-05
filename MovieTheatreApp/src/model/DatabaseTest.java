package model;

import java.sql.SQLException;

public class DatabaseTest {

    public static void main(String[] args) throws SQLException {
//        Database myDatabase = new Database();


        System.out.println(Database.getMovieDB());

        for (Movie m: Database.getMovieDB()) {
            System.out.println(m.getShowings());
        }

        System.out.println(Database.getUserDB());

        System.out.println(Database.getRegisteredUserDB());


    }
}
