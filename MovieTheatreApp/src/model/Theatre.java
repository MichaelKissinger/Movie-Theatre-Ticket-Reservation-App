package model;

import java.util.ArrayList;

public class Theatre {

    int theatreId;
    ArrayList<Movie> movieList;


    public Theatre(int id)
    {
        this.theatreId = id;
        movieList = Database.loadMovies();
    }

    public Movie searchMovies(String title)
    {
        for (Movie m: movieList)
        {
            if (m.getTitle().equals(title))
            {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Movie> displayAllMovies()
    {
        for (Movie m: movieList)
        {
            System.out.println(m);

        }
        return movieList;
    }

    public ArrayList<Movie> getMovies()
    {
        return  movieList;
    }
}
