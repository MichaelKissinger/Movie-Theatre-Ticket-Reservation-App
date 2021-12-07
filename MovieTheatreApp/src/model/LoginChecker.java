package model;

import java.sql.SQLException;

public class LoginChecker {

    private LoginChecker() {}

    public static RegisteredUser AuthenticateRegisteredUser(String email, String password) throws SQLException {
        Database database = Database.getDatabase();
        for(RegisteredUser user: database.getRegisteredUserDB()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static User AuthenticateOrdinaryUser(String email) throws SQLException {
        Database database = Database.getDatabase();
        for(User user: database.getUserDB()) {
            if (user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}