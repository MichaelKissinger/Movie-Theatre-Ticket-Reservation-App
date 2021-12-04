package model;

import java.sql.SQLException;

public class DatabaseTest {

    public static void main(String[] args) throws SQLException {
        Database myDatabase = new Database();
        System.out.println(myDatabase.getMovieDB());

        for (Movie m: myDatabase.getMovieDB()) {
            m.getShowings();
        }


    }
}
