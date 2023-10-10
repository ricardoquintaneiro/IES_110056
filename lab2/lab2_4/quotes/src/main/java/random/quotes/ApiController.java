package random.quotes;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@GetMapping("/api/quote")
	public Quote quote() {
		return new Quote();
	}

	@GetMapping("/api/shows")
	public Show show() {
		return new Show();
	}

	@GetMapping("/api/quotes")
	public Quotes quotes(@RequestParam(value = "show", defaultValue = "300") String show) {
		
		return new Quotes(show, );
	}
}