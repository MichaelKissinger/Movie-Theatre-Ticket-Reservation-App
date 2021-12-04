import view.LoginView;
import view.WelcomeView;

import javax.swing.*;

public class MovieTheatreApp {

    public static void main(String args[]) {

        // Creates a GUI capable of accessing all of the views.
        WelcomeView theTerminal = new WelcomeView();

        // Shows the GUI
        theTerminal.setVisible(true);
        theTerminal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}