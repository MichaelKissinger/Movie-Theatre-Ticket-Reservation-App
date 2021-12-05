package controller;

import model.CreditCard;
import model.RegisteredUser;
import model.User;
import view.RegisterView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Date;

public class RegisterController {
    private User user;

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

            System.out.println(registerView.getCard().length());
            try{
                if(registerView.getCard().length()!=16){
                    throw(new NumberFormatException());
                }
                System.out.println("first if out ");
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
                CreditCard creditCard = new CreditCard(
                        cardholderName,card, month, year, cvv);
                //TODO authenticate creditcard
                //TODO make transaction

                try {
                    RegisteredUser newUser = new RegisteredUser(user.getUserId(),
                            user.getEmail(), true, name, address, password,
                            true,java.util.Calendar.getInstance().getTime());
                    System.out.println(newUser.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                //TODO UPDATE THE USER DATABASE BASED ON INFO ABOVE HERE


                registerView.setVisible(false);
            }

        });
        registerView.addCancelButtonListener(e->{
            try{
                TerminalController terminalController = new TerminalController(this.user);
            } catch(SQLException err){
                err.printStackTrace();
            }
            registerView.setVisible(false);

        });

    }



}
