package level1;

/**
 * Stack Stabilization (Chapter 1)
 * <p>
 * Note: Chapter 2 is a harder version of this puzzle.
 * <p>
 * There's a stack of N inflatable discs, with the ith disc from the top having
 * an initial radius of Ri inches.
 * <p>
 * The stack is considered unstable if it includes at least one disc whose
 * radius is larger than or equal to that of the disc directly under it. In
 * other words, for the stack to be stable, each disc must have a strictly
 * smaller radius than that of the disc directly under it.
 * <p>
 * As long as the stack is unstable, you can repeatedly choose any disc of your
 * choice and deflate it down to have a radius of your choice which is strictly
 * smaller than the disc’s prior radius. The new radius must be a positive
 * integer number of inches.
 * <p>
 * Determine the minimum number of discs which need to be deflated in order to
 * make the stack stable, if this is possible at all. If it is impossible to
 * stabilize the stack, return −1 instead.
 * <p>
 * Constraints<br>
 * 1 ≤ N ≤ 50<br>
 * 1 ≤ Ri ≤ 1,000,000,000<br>
 * <p>
 * Sample test case #1<br>
 * N = 5<br>
 * R = [2, 5, 3, 6, 5]<br>
 * Expected Return Value = 3<br>
 * <p>
 * Sample test case #2<br>
 * N = 3<br>
 * R = [100, 100, 100]<br>
 * Expected Return Value = 2<br>
 * <p>
 * Sample test case #3<br>
 * N = 4<br>
 * R = [6, 5, 4, 3]<br>
 * Expected Return Value = -1<br>
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, the discs (from top to bottom) have radii of
 * ["2","5","3","6","5"]. One optimal way to stabilize the stack is by deflating
 * disc 1 from "2" to "1", deflating disc 2 from "5" to "2", and deflating disc
 * 4 from "6" to "4". This yields final radii of ["1", "2", "3", "4", "5"].
 * <p>
 * In the second case, one optimal way to stabilize the stack is by deflating
 * disc 1 from "100" to "1" and disc 2 from "100" to "10".
 * <p>
 * In the third case, it is impossible to make the stack stable after any number
 * of deflations.
 */
public class StackStabilization1 {

	// Congratulations, you solved 33 / 33 test cases!
	public int getMinimumDeflatedDiscCount(int N, int[] R) {
		int count = 0;
		int previous = R[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			if (R[i] >= previous) {
				R[i] = previous - 1;
				count++;
			}
			if (R[i] <= 0)
				return -1;

			previous = R[i];
		}
		return count;
	}

}
