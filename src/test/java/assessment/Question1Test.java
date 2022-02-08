package assessment;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class Question1Test {

	@Test
	public void Test1() {
		int numToys = 6;
		int topToys = 2;
		String[] toys = new String[] { "elmo", "elsa", "legos", "drone", "tablet", "warcraft" };
		int numQuotes = 6;
		String[] quotes = new String[] { "Elmo is the hottest toy of the season! Elmo will be on every kid's wishlist",
				"The new Elmo dolls are super high quality.", "Expect the Elsa dolls to be very popular this year",
				"Elsa and Elmo are the toys I'll be buying for my kids.",
				"For parents of older kids, look into buying them a drone.",
				"Warcraft is slowly rising in popularity ahead of the holiday season." };
		assertArrayEquals(new String[] { "elmo", "elsa" }, new Question1()
				.popularNToys(numToys, topToys, Arrays.asList(toys), numQuotes, Arrays.asList(quotes)).toArray());
	}

	@Test
	public void Test2() {
		int numToys = 5;
		int topToys = 2;
		String[] toys = new String[] { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		int numQuotes = 3;
		String[] quotes = new String[] { "Best services provided by anacell", "betacellular has great services",
				"anacell provides much better services than all other" };
		assertArrayEquals(new String[] { "anacell", "betacellular" }, new Question1()
				.popularNToys(numToys, topToys, Arrays.asList(toys), numQuotes, Arrays.asList(quotes)).toArray());
	}

	@Test
	public void Test3() {
		int numToys = 5;
		int topToys = 2;
		String[] toys = new String[] { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		int numQuotes = 5;
		String[] quotes = new String[] { "I love anacell Best services provided by anacell in the town",
				"betacellular has great services", "deltacellular provides much better services than betacelullar",
				"cetracular is worse than eurocell", "betacellular is better than deltacellular" };
		assertArrayEquals(new String[] { "betacellular", "deltacellular" }, new Question1()
				.popularNToys(numToys, topToys, Arrays.asList(toys), numQuotes, Arrays.asList(quotes)).toArray());
	}

}
