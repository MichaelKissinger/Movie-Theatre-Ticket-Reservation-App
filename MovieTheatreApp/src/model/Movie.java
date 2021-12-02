package model;

import java.util.ArrayList;
import java.util.Date;

public class Movie {

    int movieId;
    String title;
    String description;
    ArrayList<Showing> showings;

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", showings=" + showings +
                '}';
    }

    public Movie(String title, String synopsis, int id)
    {
        setTitle(title);
        setDescription(synopsis);
        setMovieId(id);
        showings = new ArrayList<Showing>();
    }

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


}
