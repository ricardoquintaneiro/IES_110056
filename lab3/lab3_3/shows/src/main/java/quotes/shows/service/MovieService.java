package quotes.shows.service;

import quotes.shows.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie Movie);

    Movie getMovieById(Long MovieId);

    List<Movie> getAllMovies();

    Movie updateMovie(Movie Movie);

    void deleteMovie(Long MovieId);

    Movie getMovieByTitle(String title);

    List<Movie> getMoviesFromYear(String year);
}
