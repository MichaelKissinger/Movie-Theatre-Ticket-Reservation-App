package controller;

import model.User;
import view.TerminalView;

import javax.swing.*;

public class TerminalController {
    TerminalView terminalView;
    User user;

    public TerminalController(User user, TerminalView terminalView){
        this.user = user;
        terminalView = new TerminalView();
        this.terminalView.setVisible();

        terminalView.addSearchMovieListener(e -> {

        });

        terminalView.addBuyMovieTicketListener(e -> {

        });

        terminalView.addCancelTicketListener(e->{

        });

        terminalView.registerListener(e->{

        });

        terminalView.viewEmailListener(e->{

        });
    }



















}
