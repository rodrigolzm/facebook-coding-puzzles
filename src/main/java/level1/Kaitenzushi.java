package level1;

import java.util.LinkedHashMap;

/**
 * Kaitenzushi
 * <p>
 * There are N dishes in a row on a kaiten belt, with the ith dish being of type
 * Di. Some dishes may be of the same type as one another.
 * <p>
 * You're very hungry, but you'd also like to keep things interesting. The N
 * dishes will arrive in front of you, one after another in order, and for each
 * one you'll eat it as long as it isn't the same type as any of the previous K
 * dishes you've eaten. You eat very fast, so you can consume a dish before the
 * next one gets to you.
 * <p>
 * Determine how many dishes you'll end up eating.
 * <p>
 * Please take care to write a solution which runs within the time limit.
 * <p>
 * Constraints<br>
 * 1 ≤ N ≤ 500,000<br>
 * 1 ≤ K ≤ N<br>
 * 1 ≤ Di ≤ 1,000,000
 * <p>
 * Sample Test Case #1<br>
 * N = 6<br>
 * D = [1, 2, 3, 3, 2, 1]<br>
 * K = 1<br>
 * Expected Return Value = 5
 * <p>
 * Sample Test Case #2<br>
 * N = 6<br>
 * D = [1, 2, 3, 3, 2, 1]<br>
 * K = 2<br>
 * Expected Return Value = 4
 * <p>
 * Sample Test Case #3<br>
 * N = 7<br>
 * D = [1, 2, 1, 2, 1, 2, 1]<br>
 * K = 2<br>
 * Expected Return Value = 2
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, the dishes have types of [1,2,3,3,2,1], so you'll eat the
 * first 3 dishes, skip the next one as it's another type-3 dish, and then eat
 * the last 2.
 * <p>
 * In the second case, you won't eat a dish if it has the same type as either of
 * the previous 2 dishes you've eaten. After eating the first, second, and third
 * dishes, you'll skip the fourth and fifth dishes as they're the same type as
 * the last 2 dishes that you've eaten. You'll then eat the last dish, consuming
 * 4 dishes total.
 * <p>
 * In the third case, once you eat the first two dishes you won't eat any of the
 * remaining dishes.
 */
public class Kaitenzushi {

	// Congratulations, you solved 33 / 33 test cases!
	public int getMaximumEatenDishCount(int N, int[] D, int K) {
		int count = 0;

		LinkedHashMap<Integer, Void> map = new LinkedHashMap<Integer, Void>();

		for (int i = 0; i < D.length; i++) {
			if (!map.containsKey(D[i])) {
				if (!map.isEmpty() && map.size() >= K) {
					map.remove(map.keySet().iterator().next());
				}
				map.put(D[i], null);
				count++;
			}
		}

		return count;
	}

}
