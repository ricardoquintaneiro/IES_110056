package quotes.shows.service.impl;

import lombok.AllArgsConstructor;
import quotes.shows.entity.Movie;
import quotes.shows.entity.Quote;
import quotes.shows.repository.QuoteRepository;
import quotes.shows.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {
     
    private QuoteRepository quoteRepository;
     
    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote getQuoteById(Long quoteId) {
        Optional<Quote> optionalQuote = quoteRepository.findById(quoteId);
        return optionalQuote.get();
    }

    @Override
    public Quote getQuoteFromMovie(int movieId) {
        Quote quote = quoteRepository.getQuoteFromMovie(movieId);
        return quote;
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public List<Quote> getQuotes(int movieId) {
        List<Quote> quotes = quoteRepository.getQuotes(movieId);
        return quotes;
    }

    @Override
    public Quote getRandomQuote() {
        Quote quote = quoteRepository.getRandomQuote();
        return quote;
    }

    @Override
    public Quote updateQuote(Quote quote) {
        Quote existingQuote = quoteRepository.findById(quote.getId()).get();
        existingQuote.setMovie(quote.getMovie());
        existingQuote.setQuote(quote.getQuote());
        Quote updatedQuote = quoteRepository.save(existingQuote);
        return updatedQuote;
    }

    @Override
    public void deleteQuote(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    @Override
    public Movie getMovieFromQuote(int quoteId) {
        Movie movie = quoteRepository.getMovieFromQuote(quoteId);
        return movie;
    }
    
}
