package level1;

import java.util.Arrays;

/**
 * Scoreboard Inference (Chapter 1)
 * <p>
 * Note: Chapter 2 is a harder version of this puzzle. The only difference is a
 * larger set of possible problem point values.
 * <p>
 * You are spectating a programming contest with N competitors, each trying to
 * independently solve the same set of programming problems. Each problem has a
 * point value, which is either 1 or 2.
 * <p>
 * On the scoreboard, you observe that the ith competitor has attained a score
 * of Si, which is a positive integer equal to the sum of the point values of
 * all the problems they have solved.
 * <p>
 * The scoreboard does not display the number of problems in the contest, nor
 * their point values. Using the information available, you would like to
 * determine the minimum possible number of problems in the contest.
 * <p>
 * Constraints<br>
 * 1 ≤ N ≤ 500,000<br>
 * 1 ≤ Si ≤ 1,000,000,000<br>
 * <p>
 * Sample test case #1<br>
 * N = 6<br>
 * S = [1, 2, 3, 4, 5, 6]<br>
 * Expected Return Value = 4<br>
 * <p>
 * Sample test case #2<br>
 * N = 4<br>
 * S = [4, 3, 3, 4]<br>
 * Expected Return Value = 3<br>
 * <p>
 * Sample test case #3<br>
 * N = 4<br>
 * S = [2, 4, 6, 8]<br>
 * Expected Return Value = 4<br>
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, it's possible that there are as few as 4 problems in the
 * contest, for example with point values [1,1,2,2]. The 6 competitors could
 * have solved the following subsets of problems:
 * <p>
 * Problem 1 (1 point)<br>
 * Problem 3 (2 points)<br>
 * Problems 2 and 3 (1 + 2 = 3 points)<br>
 * Problems 1, 2, and 4 (1 + 1 + 2 = 4 points)<br>
 * Problems 2, 3, and 4 (1 + 2 + 2 = 5 points)<br>
 * All 4 problems (1 + 1 + 2 + 2 = 6 points)<br>
 * <p>
 * It is impossible for all 6 competitors to have achieved their scores if there
 * are fewer than 4 problems.
 * <p>
 * In the second case, one optimal set of point values is [1,1,2].<br>
 * In the third case, one optimal set of point values is [2,2,2,2].
 */
public class ScoreboardInference1 {

	// Congratulations, you solved 34 / 34 test cases!
	public int getMinProblemCount(int N, int[] S) {
		Arrays.sort(S);
		int result = S[N - 1] / 2;
		for (int s : S) {
			if (s % 2 == 1) {
				result++;
				break;
			}
		}
		return result;
	}

}
