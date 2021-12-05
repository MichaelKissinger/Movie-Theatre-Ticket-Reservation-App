package model;

import java.sql.SQLException;

public class LoginChecker {

    private LoginChecker() {}

    public static RegisteredUser AuthenticateRegisteredUser(String email, String password) throws SQLException {
        for(RegisteredUser user: Database.getRegisteredUserDB()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public boolean AuthenticateOrdinaryUser(String email){
        return true;
    }
}