package model;

import java.sql.SQLException;

/**
 * LoginChecker class is used to check the email and password the registered user enters
 * to ensure it is in the database, then returns the matching user.
 * If a guest user signs in, it checks if the guest email in already in the database,
 * and if os returns information associated with that user's email.
 */
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