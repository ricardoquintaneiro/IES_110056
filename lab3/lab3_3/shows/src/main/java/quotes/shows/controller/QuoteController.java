package quotes.shows.controller;

import lombok.AllArgsConstructor;
import quotes.shows.entity.Quote;
import quotes.shows.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("quotes")
public class QuoteController {

    private QuoteService quoteService;

    // build create Quote REST API
    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote){
        Quote savedQuote = quoteService.createQuote(quote);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }

    // build get quote by id REST API
    // http://localhost:8080/quotes/1
    @GetMapping("{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable("id") Long quoteId){
        Quote quote = quoteService.getQuoteById(quoteId);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }
    
    // Build Get All Quotes REST API
    // http://localhost:8080/quotes
    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes(){
        List<Quote> quotes = quoteService.getAllQuotes();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    // Build Update Quote REST API
    @PutMapping("{id}")
    // http://localhost:8080/quotes/1
    public ResponseEntity<Quote> updateQuote(@PathVariable("id") Long quoteId,
                                           @RequestBody Quote quote){
        quote.setId(quoteId);
        Quote updatedQuote = quoteService.updateQuote(quote);
        return new ResponseEntity<>(updatedQuote, HttpStatus.OK);
    }

    // Build Delete Quote REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteQuote(@PathVariable("id") Long quoteId){
        quoteService.deleteQuote(quoteId);
        return new ResponseEntity<>("Quote successfully deleted!", HttpStatus.OK);
    }
    
    // GET quote by title REST API
    // GET http://localhost:8080/quotes?movie_id={movie_id}
    @GetMapping(params = "movie_id")
    public ResponseEntity<List<Quote>> getQuotesFromMovie(@RequestParam int movie_id) { 
        List<Quote> quotes = quoteService.getQuotes(movie_id);
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    // GET quotes by year REST API
    // GET http://localhost:8080/quotes?year={year}
    @GetMapping(params = "year")
    public ResponseEntity<List<Quote>> getQuotesFromYear(@RequestParam String year){
        List<Quote> quotes = quoteService.getQuotesFromYear(year);
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }
}
