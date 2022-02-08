package level2;

/**
 * Director of Photography (Chapter 2)
 * <p>
 * Note: Chapter 1 is an easier version of this puzzle. The only difference is a
 * smaller constraint on N.
 * <p>
 * A photography set consists of N cells in a row, numbered from 1 to N in
 * order, and can be represented by a string C of length N. Each cell i is one
 * of the following types (indicated by Ci, the ith character of C):
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
 * 1 ≤ N ≤ 300,000<br>
 * 1 ≤ X ≤ Y ≤ N<br>
 * <p>
 * Sample test case #1<br>
 * N = 5<br>
 * C = APABA<br>
 * X = 1<br>
 * Y = 2<br>
 * Expected Return Value = 1<br>
 * <p>
 * Sample test case #2<br>
 * N = 5<br>
 * C = APABA<br>
 * X = 2<br>
 * Y = 3<br>
 * Expected Return Value = 0<br>
 * <p>
 * Sample test case #3<br>
 * N = 8<br>
 * C = .PBAAP.B<br>
 * X = 1<br>
 * Y = 3<br>
 * Expected Return Value = 3<br>
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
 * In the third case, there are 4 possible photographs, illustrated as
 * follows:<br>
 * .P.A...B<br>
 * .P..A..B<br>
 * ..BA.P..<br>
 * ..B.AP..<br>
 * <p>
 * All are artistic except the first, where the artist and backdrop exceed the
 * maximum distance of 3.
 */
public class DirectorofPhotography2 {
	
	//You solved 34 / 39 test cases. Time Limit Exceeded on 5 test cases
	public long getArtisticPhotographCount(int N, String C, int X, int Y) {
		long count = 0;
		char[] c = C.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'A') {
				int[] left = count(C, i - Y, i - X);
				if (left[0] > 0 || left[1] > 0) {
					int[] right = count(C, i + X, i + Y);
					count += (left[0] * right[1]) + (left[1] * right[0]);					
				}
			}
		}
		return count;
	}
	
	private int[] count(String s, int start, int end) {		
		int[] counters = new int[2];
		
		if (end < 0 || start >= s.length())
			return counters;
		
		start = Math.max(start, 0);
		end = Math.min(end, s.length() - 1);
		
		String sub = s.substring(start, end + 1);
		for (char c : sub.toCharArray()) {
			if (c == 'P')
				counters[0]++;
			else if (c == 'B')
				counters[1]++;
		}
		return counters;
	}
	
}
