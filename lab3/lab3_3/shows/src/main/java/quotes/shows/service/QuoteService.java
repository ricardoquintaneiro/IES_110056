package quotes.shows.service;

import quotes.shows.entity.Movie;
import quotes.shows.entity.Quote;

import java.util.List;
import java.util.Optional;

public interface QuoteService {
    Quote createQuote(Quote quote);

    Quote getQuoteById(Long quoteId);

    Quote getQuoteFromMovie(Long movieId);

    List<Quote> getAllQuotes();

    List<Quote> getQuotes(Long movieId);

    Optional<Quote> getRandomQuote();

    Quote updateQuote(Quote quote);

    void deleteQuote(Long quoteId);

    Movie getMovieFromQuote(Long quoteId);
}
