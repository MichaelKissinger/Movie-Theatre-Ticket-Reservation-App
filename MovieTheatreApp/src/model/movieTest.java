package model;

public class movieTest {

    public static void main(String[] args) {

        Theatre t = new Theatre(1);
//        User customer = new User(1, "nicolas.lamarca@ucalgary.ca");
       t.displayAllMovies();
        //t.displayAllMovies();
        Movie m = t.searchMovies("Fast and Furious");
        //m.getShowings();






    }
}
