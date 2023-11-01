package quotes.shows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import quotes.shows.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
     
  Movie findByTitle(String title);
  
  List<Movie> findByYear(String year);
}
