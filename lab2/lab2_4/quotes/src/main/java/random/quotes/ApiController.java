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
		int showId = quoteMap.keySet().iterator().next();
		String showName = quoteService.getShowName(showId);
		String quote = quoteMap.get(showId);
		return new Quote(showId, showName, quote);
	}

	@GetMapping("/api/shows")
	public Shows shows() {
		return new Shows(quoteService.getShows());
	}

	@GetMapping("/api/quotes")
	public ShowQuotes quotes(@RequestParam(value = "show", defaultValue = "0") int showId) {
		String showName = quoteService.getShowName(showId);
		List<String> showQuotes = quoteService.getQuotes(showId);
		return new ShowQuotes(showId, showName, showQuotes);
	}
}