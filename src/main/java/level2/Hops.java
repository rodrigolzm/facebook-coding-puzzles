package level2;

import java.util.Arrays;

/**
 * Hops
 * <p>
 * A family of frogs in a pond are traveling towards dry land to hibernate. They
 * hope to do so by hopping across a trail of N lily pads, numbered from 1 to N
 * in order.
 * <p>
 * There are F frogs, numbered from 1 to F. Frog i is currently perched atop
 * lily pad Pi. No two frogs are currently on the same lily pad. Lily pad N is
 * right next to the shore, and none of the frogs are initially on lily pad N.
 * <p>
 * Each second, one frog may hop along the trail towards lily pad N. When a frog
 * hops, it moves to the nearest lily pad after its current lily pad which is
 * not currently occupied by another frog (hopping over any other frogs on
 * intermediate lily pads along the way). If this causes it to reach lily pad N,
 * it will immediately exit onto the shore. Multiple frogs may not
 * simultaneously hop during the same second.
 * <p>
 * Assuming the frogs work together optimally when deciding which frog should
 * hop during each second, determine the minimum number of seconds required for
 * all F of them to reach the shore.
 * <p>
 * Constraints<br>
 * 2 ≤ N ≤ 10^12<br>
 * 1 ≤ F ≤ 500,000<br>
 * 1 ≤ Pi ≤ N−1<br>
 * <p>
 * Sample test case #1<br>
 * N = 3<br>
 * F = 1<br>
 * P = [1]<br>
 * Expected Return Value = 2<br>
 * <p>
 * Sample test case #2<br>
 * N = 6<br>
 * F = 3<br>
 * P = [5, 2, 4]<br>
 * Expected Return Value = 4<br>
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, there are 3 lily pads and 1 frog. The frog is initially
 * atop lily pad 1 and will take 2 hops to reach lily pad 3.
 * <p>
 * In the second case, there are 6 lily pads, with frogs on lily pads 5, 2, and
 * 4. Initially the lily pads and frog numbers can be represented as .2.31.
 * <p>
 * One optimal sequence of hops is:<br>
 * 1. Frog 2 hops forward to lily pad 3:<br>
 * ..231.<br>
 * 2. Frog 2 hops over frogs 1 and 3, onto lily pad 6 and exiting onto the
 * shore:<br>
 * ...31.<br>
 * 3. Frog 3 hops over frog 1, onto lily pad 6 and exiting onto the shore:<br>
 * ....1.<br>
 * 4. Frog 1 hops onto lily pad 6, exiting onto the shore.<br>
 */
public class Hops {

	public long getSecondsRequired(long N, int F, long[] P) {
		long count = 0;
		Arrays.sort(P);		
		P = Arrays.copyOf(P, P.length + 1);
		P[P.length - 1] = N;
		for (int i = 0; i < P.length - 1; i++) {
			count += P[i + 1] - 1 - P[i];
		}		
		return count + F;
	}

}
