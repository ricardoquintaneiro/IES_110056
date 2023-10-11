package random.quotes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class QuoteService {

    private Map<Integer, String> shows = new HashMap<>();
    private Map<Integer, Set<String>> quotes = new HashMap<>();

    public QuoteService() {
        shows.put(0, "KINGSMAN: The Secret Service (2015)");
        quotes.put(0, new HashSet<>());
        quotes.get(0).add("Manners maketh man - KINGSMAN: The Secret Service (2015)");
        shows.put(1, "The Lord of the Rings: The Fellowship of the Ring (2001)");
        quotes.put(1, new HashSet<>());
        quotes.get(1).add("I don't know half of you half as well as I should like; and I like less than half of you half as well as you deserve. - The Lord of the Rings: The Fellowship of the Ring (2001)");
        shows.put(2, "Avengers: Endgame (2019)");
        quotes.put(2, new HashSet<>());
        quotes.get(2).add("I love you 3000. - Avengers: Endgame (2019)");
        shows.put(3, "Harry Potter and the Sorcerer's Stone (2001)");
        quotes.put(3, new HashSet<>());
        quotes.get(3).add("You're a wizard, Harry. - Harry Potter and the Sorcerer's Stone (2001)");
        shows.put(4, "The Matrix (1999)");
        quotes.put(4, new HashSet<>());
        quotes.get(4).add("Ignorance Is Bliss - The Matrix (1999)");
        quotes.get(4).add("I know kung fu. - The Matrix (1999)");
        quotes.get(4).add("There is no spoon. - The Matrix (1999)");
        shows.put(5, "The Dark Knight (2008)");
        quotes.put(5, new HashSet<>());
        quotes.get(5).add("Some men just want to watch the world burn. - The Dark Knight (2008)");
    }

    public String getQuote(int showId) {
        int size = quotes.get(showId).size();
        int item = (int) (Math.random() * size);
        return quotes.get(showId).toArray()[item].toString();
    }

    public Map<Integer, String> getShows() {
        return shows;
    }

    public Map<Integer, String> getRandomQuote() {
        int size = shows.size();
        int item = (int) (Math.random() * size);
        Map<Integer, String> map = new HashMap<>();
        map.put(item, getQuote(item));
        return map;
    }

    public List<String> getQuotes(int showId) {
        return quotes.get(showId).stream().collect(Collectors.toList());
    }

}
