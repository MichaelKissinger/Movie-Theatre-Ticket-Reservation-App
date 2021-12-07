package controller;

import model.*;
import view.RegisterView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.sql.Date;

public class RegisterController {
    private User user;
    private RegisteredUser regUser;

    public RegisterController(User user){
        this.user = user;

        RegisterView registerView = new RegisterView();
        registerView.setVisible(true);
        registerView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        registerView.addRegisterButtonListener(e->{
            boolean errCheck = true;

            String address ="";
            String name="";
            String password="";
            String cardholderName="";
            int year=0;
            int month = 0;
            int cvv=0;
            String card="";

            try{
                if((registerView.getAddress().strip().equals(""))||
                        (registerView.getName().strip().equals(""))||
                        (registerView.getPassword().strip().equals(""))||
                        (registerView.getCardHolderName().strip()).equals("")){
                    throw(new IllegalArgumentException());
                }
                address = registerView.getAddress();
                name = registerView.getName();
                password = registerView.getPassword();
                cardholderName = registerView.getCardHolderName();
            }catch(IllegalArgumentException err){
                registerView.alert("Please enter an address, name, and password");
                errCheck = false;
            }

            try{
                if(registerView.getCard().length()!=16){
                    throw(new NumberFormatException());
                }
                for(int i =0; i <registerView.getCard().length(); i++){
                    int z =Integer.parseInt(registerView.getCard().substring(i,i+1));
                }
                card = registerView.getCard();
            }catch(NumberFormatException err){
                errCheck = false;
                registerView.alert("Please enter a valid credit card number");
            }
            try{
                if(registerView.getMonth()==0 || registerView.getYear()<=20) throw(new NumberFormatException());

                month = registerView.getMonth();
                year = registerView.getYear();
            }catch(NumberFormatException err){
                errCheck = false;
                registerView.alert("Please enter a valid credit card expiry month and year");
            }

            try{
                cvv = Integer.parseInt(registerView.getCvv());
            }catch(NumberFormatException err){
                errCheck = false;
                registerView.alert("Please enter a cvv number");
            }
            if(errCheck==true) {
//                CreditCard creditCard = new CreditCard(
//                        cardholderName,card, month, year, cvv);
                //TODO authenticate creditcard
                //TODO make transaction
//java.util.Calendar.getInstance().getTime()
                Date lastPaymentDate = new Date(System.currentTimeMillis());
                try {
                    RegisteredUser newUser = new RegisteredUser(user.getUserId(),
                            user.getEmail(), true, name, address, password,
                            true, lastPaymentDate);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println(new Date(System.currentTimeMillis()));
                try {
                    Database.registerUser(user.getUserId(), name, address, password, lastPaymentDate);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    regUser = LoginChecker.AuthenticateRegisteredUser(user.getEmail(), password);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    TerminalController terminalController = new TerminalController(regUser);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                registerView.setVisible(false);
            }
        });
        registerView.addCancelButtonListener(e->{
            try{
                TerminalController terminalController = new TerminalController(this.user);
                registerView.setVisible(false);
            } catch(SQLException err){
                err.printStackTrace();
            }


        });


    }



}
