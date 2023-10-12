package random.quotes;

import java.util.List;

public record ShowQuotes(Integer showId, String showName, List<String> quotes) { }