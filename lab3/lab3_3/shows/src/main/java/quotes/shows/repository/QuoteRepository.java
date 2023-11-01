package quotes.shows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import quotes.shows.entity.Movie;
import quotes.shows.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    Quote getQuoteFromMovie(int movieId);

    List<Quote> getQuotes(int movieId);

    Quote getRandomQuote();

    Movie getMovieFromQuote(int quoteId);
     
}

