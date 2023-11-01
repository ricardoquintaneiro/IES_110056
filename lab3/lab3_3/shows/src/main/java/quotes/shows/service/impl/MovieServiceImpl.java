
package quotes.shows.service.impl;

import lombok.AllArgsConstructor;
import quotes.shows.entity.Movie;
import quotes.shows.repository.MovieRepository;
import quotes.shows.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        return optionalMovie.get();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).get();
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setYear(movie.getYear());
        Movie updatedMovie = movieRepository.save(existingMovie);
        return updatedMovie;
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public Movie getMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title);
        return movie;
    }

    @Override
    public List<Movie> getMoviesFromYear(String year) {
        List<Movie> movies = movieRepository.findByYear(year);
        return movies;
    }
}