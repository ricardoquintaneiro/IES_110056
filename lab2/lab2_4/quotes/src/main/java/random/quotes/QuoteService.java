package random.quotes;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public final class QuoteService {

    private final Map<Integer, String> shows = new HashMap<>();
    private final Map<Integer, List<String>> quotes = new HashMap<>();

    public QuoteService() {
        addShowAndQuotes(0, "KINGSMAN: The Secret Service (2015)", "Manners maketh man");
        addShowAndQuotes(1, "The Lord of the Rings: The Fellowship of the Ring (2001)",
                "I don't know half of you half as well as I should like; and I like less than half of you half as well as you deserve.");
        addShowAndQuotes(2, "Avengers: Endgame (2019)", "I love you 3000.");
        addShowAndQuotes(3, "Harry Potter and the Sorcerer's Stone (2001)", "You're a wizard, Harry.");
        addShowAndQuotes(4, "The Matrix (1999)", "Ignorance Is Bliss", "I know kung fu", "There is no spoon");
        addShowAndQuotes(5, "The Dark Knight (2008)", "Some men just want to watch the world burn");
    }

    private void addShowAndQuotes(int showId, String showName, String... quoteArray) {
        shows.put(showId, showName);
        quotes.put(showId, Arrays.asList(quoteArray));
    }

    public String getQuote(int showId) {
        List<String> showQuotes = quotes.get(showId);
        if (showQuotes == null || showQuotes.isEmpty()) {
            return "No quotes available for this show.";
        }
        int randomIndex = (int) (Math.random() * showQuotes.size());
        return showQuotes.get(randomIndex);
    }

    public Map<Integer, String> getShows() {
        return shows;
    }

    public Map<Integer, String> getRandomQuote() {
        List<Map.Entry<Integer, String>> allQuotes = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : quotes.entrySet()) {
            int showId = entry.getKey();
            List<String> showQuotes = entry.getValue();
            for (String quote : showQuotes) {
                allQuotes.add(new AbstractMap.SimpleEntry<>(showId, quote));
            }
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allQuotes.size());
        Map.Entry<Integer, String> randomEntry = allQuotes.get(randomIndex);
        int randomShowId = randomEntry.getKey();
        String randomQuote = randomEntry.getValue();

        return Map.of(randomShowId, randomQuote);
    }

    public List<String> getQuotes(int showId) {
        return quotes.get(showId).stream().collect(Collectors.toList());
    }

    public String getShowName(int showId) {
        return shows.get(showId);
    }

}
