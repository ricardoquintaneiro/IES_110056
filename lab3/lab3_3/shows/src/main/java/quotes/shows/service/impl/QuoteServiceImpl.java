package quotes.shows.service.impl;

import lombok.AllArgsConstructor;
import quotes.shows.entity.Movie;
import quotes.shows.entity.Quote;
import quotes.shows.repository.QuoteRepository;
import quotes.shows.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
    public Quote getQuoteFromMovie(Long movieId) {
        List<Quote> quotes = quoteRepository.findByMovieId(movieId);
        Quote quote = quotes.get(new Random().nextInt(quotes.size()));
        return quote;
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public List<Quote> getQuotes(Long movieId) {
        List<Quote> quotes = quoteRepository.findByMovieId(movieId);
        return quotes;
    }

    @Override
    public Optional<Quote> getRandomQuote() {
        List<Long> ids = new ArrayList<>();
        quoteRepository.findAll().iterator().forEachRemaining(quote -> ids.add(quote.getId()));
        Optional<Quote> quote = Optional.empty();
        if (!ids.isEmpty())
            quote = quoteRepository.findById(ids.get(new Random().nextInt(ids.size())));
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
    public Movie getMovieFromQuote(Long quoteId) {
        Quote quote = quoteRepository.findById(quoteId).get();
        Movie movie = quote.getMovie();
        return movie;
    }
    
}
