package level1;

import java.util.HashSet;
import java.util.Set;

/**
 * Director of Photography (Chapter 1)
 * <p>
 * Note: Chapter 2 is a harder version of this puzzle. The only difference is a
 * larger constraint on N.
 * <p>
 * A photography set consists of N cells in a row, numbered from 1 to N in
 * order, and can be represented by a string C of length N. Each cell i is one
 * of the following types (indicated by Ci, the i ith character of C):
 * <p>
 * <ul>
 * <li>If Ci = “P”, it is allowed to contain a photographer</li>
 * <li>If Ci = “A”, it is allowed to contain an actor</li>
 * <li>If Ci = “B”, it is allowed to contain a backdrop</li>
 * <li>If Ci = “.”, it must be left empty</li>
 * </ul>
 * <p>
 * A photograph consists of a photographer, an actor, and a backdrop, such that
 * each of them is placed in a valid cell, and such that the actor is between
 * the photographer and the backdrop. Such a photograph is considered artistic
 * if the distance between the photographer and the actor is between X and Y
 * cells (inclusive), and the distance between the actor and the backdrop is
 * also between X and Y cells (inclusive). The distance between cells i and j is
 * ∣i−j∣ (the absolute value of the difference between their indices).
 * <p>
 * Determine the number of different artistic photographs which could
 * potentially be taken at the set. Two photographs are considered different if
 * they involve a different photographer cell, actor cell, and/or backdrop cell.
 * <p>
 * Constraints<br>
 * 1 ≤ N ≤ 200<br>
 * 1 ≤ X ≤ Y ≤ N<br>
 * <p>
 * Sample Test Case #1<br>
 * N = 5<br>
 * C = APABA<br>
 * X = 1<br>
 * Y = 2<br>
 * Expected Return Value = 1
 * <p>
 * Sample Test Case #2<br>
 * N = 5<br>
 * C = APABA<br>
 * X = 2<br>
 * Y = 3<br>
 * Expected Return Value = 0
 * <p>
 * Sample Test Case #3<br>
 * N = 8<br>
 * C = .PBAAP.B<br>
 * X = 1<br>
 * Y = 3<br>
 * Expected Return Value = 3
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, the absolute distances between photographer/actor and
 * actor/backdrop must be between 1 and 2. The only possible photograph that can
 * be taken is with the 3 middle cells, and it happens to be artistic.
 * <p>
 * In the second case, the only possible photograph is again taken with the 3
 * middle cells. However, as the distance requirement is between 2 and 3, it is
 * not possible to take an artistic photograph.
 * <p>
 * In the third case, there are 4 possible photographs, illustrated as follows:
 * .P.A...B <br>
 * .P..A..B <br>
 * ..BA.P.. <br>
 * ..B.AP.. <br>
 * All are artistic except the first, where the artist and backdrop exceed the
 * maximum distance of 3.
 */
public class DirectorofPhotography1 {

	// Congratulations, you solved 39 / 39 test cases!
	public int getArtisticPhotographCount(int N, String C, int X, int Y) {
		int count = 0;
		char[] c = C.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'P') {
				for (int j : find(c, i - Y, i - X, 'A')) {
					count += find(c, j - Y, j - X, 'B').size();
				}
				for (int j : find(c, i + X, i + Y, 'A')) {
					count += find(c, j + X, j + Y, 'B').size();
				}
			}
		}
		return count;
	}

	private Set<Integer> find(char[] c, int start, int end, char element) {
		Set<Integer> found = new HashSet<Integer>();
		for (int i = start; i <= end; i++) {
			if (i >= 0 && i < c.length) {
				if (c[i] == element) {
					found.add(i);
				}
			}
		}
		return found;
	}
}
