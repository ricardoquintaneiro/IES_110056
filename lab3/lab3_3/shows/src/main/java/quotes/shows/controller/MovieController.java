package quotes.shows.controller;

import lombok.AllArgsConstructor;
import quotes.shows.entity.Movie;
import quotes.shows.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("movies")
public class MovieController {

    private MovieService movieService;

    // build create Movie REST API
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie savedMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    // build get movie by id REST API
    // http://localhost:8080/movies/1
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long movieId){
        Movie movie = movieService.getMovieById(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    
    // Build Get All Movies REST API
    // http://localhost:8080/movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // Build Update Movie REST API
    @PutMapping("{id}")
    // http://localhost:8080/movies/1
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long movieId,
                                           @RequestBody Movie movie){
        movie.setId(movieId);
        Movie updatedMovie = movieService.updateMovie(movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    // Build Delete Movie REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId){
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>("Movie successfully deleted!", HttpStatus.OK);
    }
    
    // GET movie by title REST API
    // GET http://localhost:8080/movies?title={title}
    @GetMapping(params = "title")
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title) { 
        Movie movie = movieService.getMovieByTitle(title);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    // GET movies by year REST API
    // GET http://localhost:8080/movies?year={year}
    @GetMapping(params = "year")
    public ResponseEntity<List<Movie>> getMoviesFromYear(@RequestParam String year){
        List<Movie> movies = movieService.getMoviesFromYear(year);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
