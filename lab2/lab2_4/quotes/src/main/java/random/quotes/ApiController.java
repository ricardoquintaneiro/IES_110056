package random.quotes;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	private static final QuoteService quoteService = new QuoteService();

	@GetMapping("/api/quote")
	public Quote quote() {
		Map<Integer, String> quoteMap = quoteService.getRandomQuote();
		int key = quoteMap.keySet().iterator().next();
		String quote = quoteMap.get(key);
		return new Quote(key, quote);
	}

	@GetMapping("/api/shows")
	public Shows shows() {
		Map<Integer, String> shows = quoteService.getShows();
		return new Shows(shows);
	}

	@GetMapping("/api/quotes")
	public ShowQuotes quotes(@RequestParam(value = "show", defaultValue = "0") String show) {
		int showId = Integer.parseInt(show);
		List<String> quotes = quoteService.getQuotes(showId);
		return new ShowQuotes(showId, quotes);
	}
}