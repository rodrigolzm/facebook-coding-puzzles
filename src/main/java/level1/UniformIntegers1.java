package level1;

/**
 * Uniform Integers
 * <p>
 * A positive integer is considered uniform if all of its digits are equal. For
 * example, 222 is uniform, while 223 is not.
 * <p>
 * Given two positive integers A and B, determine the number of uniform integers
 * between A and B, inclusive.
 * <p>
 * Please take care to write a solution which runs within the time limit.
 * <p>
 * Constraints<br>
 * 1 ≤ A ≤ B ≤ 10^12<br>
 * <p>
 * Sample test case #1<br>
 * A = 75<br>
 * B = 300<br>
 * Expected Return Value = 5<br>
 * <p>
 * Sample test case #2<br>
 * A = 1<br>
 * B = 9<br>
 * Expected Return Value = 9<br>
 * <p>
 * Sample test case #3<br>
 * A = 999999999999<br>
 * B = 999999999999<br>
 * Expected Return Value = 1<br>
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, the uniform integers between 75 and 300 are 77, 88, 99,
 * 111, and 222.
 * <p>
 * In the second case, all 9 single-digit integers between 1 and 9 (inclusive)
 * are uniform.
 * <p>
 * In the third case, the single integer under consideration (999,999,999,999)
 * is uniform.
 */
public class UniformIntegers1 {

	// Congratulations, you solved 33 / 33 test cases!
	public int getUniformIntegerCountInInterval(long A, long B) {
		int count = 0;

		int len = Long.toString(B).length();

		for (int j = 1; j < 10; j++) {
			for (int i = 1; i <= len; i++) {
				String num = "" + j;
				while (num.length() < i)
					num += j;
				if (Long.valueOf(num) >= A && Long.valueOf(num) <= B)
					count++;
			}
		}

		return count;
	}

}
