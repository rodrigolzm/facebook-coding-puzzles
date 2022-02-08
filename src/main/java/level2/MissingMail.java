package level2;

/**
 * Missing Mail
 * <p>
 * You are the manager of a mail room which is frequently subject to theft. A
 * period of N days is about to occur, such that on the ith day, the following
 * sequence of events will occur in order:
 * <p>
 * 1. A package with a value of Vi dollars will get delivered to the mail room
 * (unless Vi = 0, in which case no package will get delivered).
 * <p>
 * 2. You can choose to pay C dollars to enter the mail room and collect all of
 * the packages there (removing them from the room), and then leave the room
 * <p>
 * 3. With probability S, all packages currently in the mail room will get
 * stolen (and therefore removed from the room).
 * <p>
 * Note that you're aware of the delivery schedule V1..N, but can only observe
 * the state of the mail room when you choose to enter it, meaning that you
 * won't immediately be aware of whether or not packages were stolen at the end
 * of any given day.
 * <p>
 * Your profit after the Nth day will be equal to the total value of all
 * packages which you collected up to that point, minus the total amount of
 * money you spent on entering the mail room.
 * <p>
 * Please determine the maximum expected profit you can achieve (in dollars).
 * <p>
 * Note: Your return value must have an absolute or relative error of at most
 * 10^−6 to be considered correct.
 * <p>
 * Constraints<br>
 * 1 ≤ N ≤ 4,000<br>
 * 0 ≤ Vi ≤ 1,000<br>
 * 1 ≤ C ≤ 1,000<br>
 * 0.0 ≤ S ≤ 1.0<br>
 * <p>
 * Sample test case #1<br>
 * N = 5<br>
 * V = [10, 2, 8, 6, 4]<br>
 * C = 5<br>
 * S = 0.0<br>
 * Expected Return Value = 25.00000000<br>
 * <p>
 * Sample test case #2<br>
 * N = 5<br>
 * V = [10, 2, 8, 6, 4]<br>
 * C = 5<br>
 * S = 1.0<br>
 * Expected Return Value = 9.00000000<br>
 * <p>
 * Sample test case #3<br>
 * N = 5<br>
 * V = [10, 2, 8, 6, 4]<br>
 * C = 3<br>
 * S = 0.5<br>
 * Expected Return Value = 17.00000000<br>
 * <p>
 * Sample test case #4<br>
 * N = 5<br>
 * V = [10, 2, 8, 6, 4]<br>
 * C = 3<br>
 * S = 0.15<br>
 * Expected Return Value = 20.10825000<br>
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, packages will never be stolen. You should therefore enter
 * the mail room just once, on the final day, at which point there are sure to
 * be 5 packages there with a total value of 10 + 2 + 8 + 6 + 4 = 30 dollars.
 * Subtracting the 5-dollar fee for entering the mail room, your profit is
 * guaranteed to be 30 − 5 = 25 dollars.
 * <p>
 * In the second case, each package is sure to be stolen at the end of the day
 * on which its delivered. You should enter the mail room on days 1, 3, and 4,
 * each time collecting just the package delivered on that day. This yields a
 * guaranteed profit of 10 + 8 + 6 − (3 ∗ 5) = 9 dollars.
 * <p>
 * In the third case, on each day, there's a 50% chance that all packages in the
 * mail room will be stolen. You should enter the mail room on days 1, 3, 4, and
 * 5. Note that, when you enter on day 3, there will be a 50% chance of the room
 * having 2 packages (with values of 2 and 8 dollars), and a 50% chance of the
 * room having just 1 package (worth 8 dollars).
 * <p>
 * In the fourth case, you should only enter the mail room on days 1 and 5.
 */
public class MissingMail {


	//You solved 7 / 24 test cases. Wrong Answer on 17 test cases
	public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
		
		double cost = 0;
		double remaining = 0;
		double worst = 0;
		
		for (int i = 0; i < N - 1; i++) {
			//depreciation
			double d = V[i];
			for (int j = 0; j < N - i - 1; j++) {
				d *= (1 - S);
			}
			
			worst += d;
			
			if (d < V[i] - C) {
				cost += V[i] + remaining - C;
				remaining = 0;
			} else {
				remaining = (V[i] + remaining) * (1 - S);
			}
		}
		
		if ((V[N - 1] + worst) - C >= 0)
			cost += V[N - 1] + remaining - C;
		
		//round
		cost *= 1000000;
		cost = (int) cost;
		cost /= 1000000;
		
		return cost;
	}

}
