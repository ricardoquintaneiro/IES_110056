package quotes.shows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import quotes.shows.entity.Movie;
import quotes.shows.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findByMovieId(Long movieId);

    // Movie getMovieFromQuote(Long quoteId);
     
}

