package quotes.shows.service;

import quotes.shows.entity.Movie;
import quotes.shows.entity.Quote;

import java.util.List;

public interface QuoteService {
    Quote createQuote(Quote quote);

    Quote getQuoteById(Long quoteId);

    Quote getQuoteFromMovie(int movieId);

    List<Quote> getAllQuotes();

    List<Quote> getQuotes(int movieId);

    Quote getRandomQuote();

    Quote updateQuote(Quote quote);

    void deleteQuote(Long quoteId);

    Movie getMovieFromQuote(int quoteId);
}
