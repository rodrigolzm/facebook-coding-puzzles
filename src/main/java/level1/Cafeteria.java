package level1;

import java.util.Arrays;

/**
 * Cafeteria
 * <p>
 * A cafeteria table consists of a row of N seats, numbered from 1 to N from
 * left to right. Social distancing guidelines require that every diner be
 * seated such that K seats to their left and K seats to their right (or all the
 * remaining seats to that side if there are fewer than K) remain empty.
 * <p>
 * There are currently M diners seated at the table, the ith of whom is in seat
 * Si. No two diners are sitting in the same seat, and the social distancing
 * guidelines are satisfied.
 * <p>
 * Determine the maximum number of additional diners who can potentially sit at
 * the table without social distancing guidelines being violated for any new or
 * existing diners, assuming that the existing diners cannot move and that the
 * additional diners will cooperate to maximize how many of them can sit down.
 * <p>
 * Please take care to write a solution which runs within the time limit.
 * <p>
 * Constraints<br>
 * 1 ≤ N ≤10 (exp 15)<br>
 * 1 ≤ K ≤ N<br>
 * 1 ≤ M ≤ 500,000<br>
 * 1 ≤ Si ≤ N<br>
 * <p>
 * Sample Test Case #1<br>
 * N = 10<br>
 * K = 1<br>
 * M = 2<br>
 * S = [2, 6]<br>
 * Expected Return Value = 3
 * <p>
 * Sample Test Case #2<br>
 * N = 15<br>
 * K = 2<br>
 * M = 3<br>
 * S = [11, 6, 14]<br>
 * Expected Return Value = 1
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, the cafeteria table has N=10 seats, with two diners
 * currently at seats 2 and 6 respectively. The table initially looks as
 * follows, with brackets covering the K=1 seat to the left and right of each
 * existing diner that may not be taken.
 * 
 * <pre>
 * 1 2 3 4 5 6 7 8 9 10<br>
 * [   ]   [   ]
 * </pre>
 * 
 * Three additional diners may sit at seats 4, 8, and 10 without violating the
 * social distancing guidelines.
 * <p>
 * In the second case, only 1 additional diner is able to join the table, by
 * sitting in any of the first 3 seats.
 */
public class Cafeteria {

	// Congratulations, you solved 32 / 32 test cases!
	public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
		long counter = 0;
		long start = 1;
		long position = 0;

		Arrays.sort(S);

		for (long seat : S) {
			position = seat - start;
			counter += Math.floor((double) position / (K + 1));
			start = seat + K + 1;
		}

		position = N - start + 1;
		counter += Math.ceil((double) position / (K + 1));

		return counter;
	}

}
