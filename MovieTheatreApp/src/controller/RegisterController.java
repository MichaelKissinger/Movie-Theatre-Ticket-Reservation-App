package controller;

import model.CreditCard;
import model.User;
import view.RegisterView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;

public class RegisterController {
    private User user;

    public RegisterController(User user){
        this.user = user;

        RegisterView registerView = new RegisterView();
        registerView.setVisible(true);
        registerView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        registerView.addRegisterButtonListener(e->{
            boolean errCheck = true;

            String address;
            String name;
            String password;

            try{
                if((registerView.getAddress().strip().equals(""))||
                        (registerView.getName().strip().equals(""))||
                        (registerView.getPassword().strip().equals(""))){
                    throw(new IllegalArgumentException());
                }
                address = registerView.getAddress();
                name = registerView.getName();
                password = registerView.getPassword();
            }catch(IllegalArgumentException err){
                registerView.alert("Please enter an address, name, and password");
                errCheck = false;
            }
            int year;
            int month;
            String card;
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
                int cvv = Integer.parseInt(registerView.getCvv());
            }catch(NumberFormatException err){
                errCheck = false;
                registerView.alert("Please enter a cvv number");
            }
            String cardHolderName = registerView.getCardHolderName();
            if(errCheck==true) {
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
