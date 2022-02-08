package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * You work on a team whose job is to understand the most sought after toys for
 * the holiday season. A teammate of yours has built a webcrawler that extracts
 * a list of quotes about toys from different articles. You need to take these
 * quotes and identify which toys are mentioned most frequently. Write an
 * algorithm that identifies the top N toys out of a list of quotes and list of
 * toys.
 * <p>
 * Your algorithm should output the top N toys mentioned most frequently in the
 * quotes.
 * <p>
 * Input<br>
 * The input to the function/method consists of five arguments:<br>
 * numToys - an integer representing the number of toys<br>
 * topToys - an integer representing the number of top toys that your algorithm
 * needs to return<br>
 * toys - a list of strings representing the toys<br>
 * numQuotes - an integer representing the number of quotes about toys<br>
 * quotes - a list of strings that consist of space-separated words representing
 * articles about toys<br>
 * <p>
 * Output<br>
 * Return a list of strings of the most popular N toys in order of most to least
 * frequently mentioned.<br>
 * <p>
 * Note<br>
 * The comparison of strings is case-insensitive.<br>
 * Multiple occurrences of a toy in a quote should be considered as a single
 * mention.<br>
 * If the value of topToys is more than the number of toys, return the names of
 * only the toys mentioned in the quotes.<br>
 * If toys are mentioned an equal number of times in quotes, sort
 * alphabetically.
 * <p>
 * Example
 * <p>
 * Input:<br>
 * numToys = 6<br>
 * topToys = 2<br>
 * toys = ["elmo","elsa","legos","drone","tablet","warcraft"]<br>
 * numQuotes = 6<br>
 * quotes = ["Elmo is the hottest toy of the season! Elmo will be on every kid's
 * wishlist", "The new Elmo dolls are super high quality.", "Expect the Elsa
 * dolls to be very popular this year", "Elsa and Elmo are the toys I'll be
 * buying for my kids.", "For parents of older kids, look into buying them a
 * drone.", "Warcraft is slowly rising in popularity ahead of the holiday
 * season."]<br>
 * <p>
 * Ouput:<br>
 * ["elmo","elsa"]
 */
public class Question1 {

	public ArrayList<String> popularNToys(int numToys, int topToys, List<String> toys, int numQuotes,
			List<String> quotes) {

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();

		for (String quote : quotes) {
			for (String toy : toys) {
				if (quote.toLowerCase().contains(toy.toLowerCase())) {
					if (!map.containsKey(toy))
						map.put(toy, 0);
					map.put(toy, map.get(toy) + 1);
				}
			}
		}

		TreeMap<Integer, TreeSet<String>> sorted = new TreeMap<Integer, TreeSet<String>>();
		for (Entry<String, Integer> e : map.entrySet()) {
			if (!sorted.containsKey(e.getValue()))
				sorted.put(e.getValue(), new TreeSet<String>());
			sorted.get(e.getValue()).add(e.getKey());
		}
		
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < topToys; i++) {
			if (sorted.isEmpty())
				break;
			result.add(sorted.lastEntry().getValue().pollFirst());
			if (sorted.lastEntry().getValue().isEmpty())
				sorted.remove(sorted.lastKey());
		}
		
		return result;
	}

}
