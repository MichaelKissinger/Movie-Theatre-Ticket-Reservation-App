package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Movie {

    int movieId;
    String title;
    String description;
    ArrayList<Showing> showings;

    //private JDBCConnect myJDBC;

    public Movie(int movieId, String title, String synopsis)
    {
        //myJDBC = new JDBCConnect();
        //myJDBC.createConnection();
        setMovieId(movieId);
        setTitle(title);
        setDescription(synopsis);
        showings = new ArrayList<Showing>();
    }

//    public void initializeShowings() throws SQLException {
//        showings = myJDBC.showingSetStatement(movieId);
//    }

    public void addShowing(Showing theShowing)
    {
        showings.add(theShowing);
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Showing> getShowings() {
        return showings;
    }

    public void setShowings(ArrayList<Showing> showings) {
        this.showings = showings;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }


}
