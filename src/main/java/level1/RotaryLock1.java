package level1;

/**
 * Rotary Lock (Chapter 1)
 * <p>
 * Note: Chapter 2 is a harder version of this puzzle.
 * <p>
 * You're trying to open a lock. The lock comes with a wheel which has the
 * integers from 1 to N arranged in a circle in order around it (with integers 1
 * and N adjacent to one another). The wheel is initially pointing at 1.
 * <p>
 * For example, the following depicts the lock for N=10 (as is presented in the
 * second sample case).
 * <p>
 * It takes 1 second to rotate the wheel by 1 unit to an adjacent integer in
 * either direction, and it takes no time to select an integer once the wheel is
 * pointing at it.
 * <p>
 * The lock will open if you enter a certain code. The code consists of a
 * sequence of M integers, the ith of which is Ci. Determine the minimum number
 * of seconds required to select all M of the code's integers in order.
 * <p>
 * Please take care to write a solution which runs within the time limit.
 * <p>
 * Constraints<br>
 * 3 ≤ N ≤ 50,000,000<br>
 * 1 ≤ M ≤ 1,000<br>
 * 1 ≤ Ci ≤ N
 * <p>
 * Sample Test Case #1<br>
 * N = 3<br>
 * M = 3<br>
 * C = [1, 2, 3]<br>
 * Expected Return Value = 2
 * <p>
 * Sample Test Case #2<br>
 * N = 10<br>
 * M = 4<br>
 * C = [9, 4, 4, 8]<br>
 * Expected Return Value = 11
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, there are 3 integers on the lock, and the sequence of
 * integers to be selected is [1,2,3]. One optimal way to enter the code is:
 * select 1 → rotate to 2 (1 second) → select 2 → rotate to 3 (1 second) →
 * select 3. The total time taken is 1+1=2 seconds.
 * <p>
 * In the second case, the lock consists of the integers 1 through 10, and the
 * sequence to be selected is [9,4,4,8]. One optimal way to enter the code is:
 * rotate from 1 backwards to 9 (2 seconds) → select 9 → rotate forwards to 4 (5
 * seconds) → select 4 twice → rotate forwards to 8 (4 seconds) → select 8. The
 * total time taken is 2+5+4=11 seconds.
 */
public class RotaryLock1 {

	// You solved 17 / 32 test cases. Wrong Answer on 15 test cases
	public long getMinCodeEntryTime(int N, int M, int[] C) {
		int sec = 0;
		int pos = 1;
		for (int next : C) {
			if (pos != next) {
				int right = calculateTimeRight(N, pos, next);
				int left = calculateTimeLeft(N, pos, next);
				sec += Math.min(right, left);
				pos = next;
			}
		}
		return sec;
	}

	private int calculateTimeRight(int N, int a, int b) {
		if (a > b)
			return (N + b) - a;
		return b - a;
	}

	private int calculateTimeLeft(int N, int a, int b) {
		if (a < b)
			return (N + a) - b;
		return a - b;
	}

}
