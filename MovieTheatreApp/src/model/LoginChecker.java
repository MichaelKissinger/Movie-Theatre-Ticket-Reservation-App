package model;

import java.sql.SQLException;

public class LoginChecker {
    Database database;
    String username;
    String password;

    public LoginChecker(String username, String password) throws SQLException {
        database = new Database();
        this.username = username;
        this.password = password;
    }

//    public boolean checkUsernamePassword() {
//        Boolean usernameCheck = false;
//        Boolean passwordCheck = false;
//        for(User a: database.getUsers()) {
//            if (a.getUserName().equals(username)){
//                usernameCheck = true;
//            }
//            if (a.getPassword().equals(password)){
//                passwordCheck = true;
//                break;
//            }
//        }
//        if (usernameCheck && passwordCheck) {
//            return true;
//
//        } else {
//            return false;
//        }
//    }
}