package level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MissingMailTest {

	@Test
	public void Test1() {
		int N = 5;
		int[] V = new int[] { 10, 2, 8, 6, 4 };
		int C = 5;
		double S = 0.0;
		assertEquals(25.000000, new MissingMail().getMaxExpectedProfit(N, V, C, S), 0);
	}

	@Test
	public void Test2() {
		int N = 5;
		int[] V = new int[] { 10, 2, 8, 6, 4 };
		int C = 5;
		double S = 1.0;
		assertEquals(9.000000, new MissingMail().getMaxExpectedProfit(N, V, C, S), 0);
	}

	@Test
	public void Test3() {
		int N = 5;
		int[] V = new int[] { 10, 2, 8, 6, 4 };
		int C = 3;
		double S = 0.5;
		assertEquals(17.000000, new MissingMail().getMaxExpectedProfit(N, V, C, S), 0);
	}

	@Test
	public void Test4() {
		int N = 5;
		int[] V = new int[] { 10, 2, 8, 6, 4 };
		int C = 3;
		double S = 0.15;
		assertEquals(20.108250, new MissingMail().getMaxExpectedProfit(N, V, C, S), 0);
	}
	
	@Test
	public void Test5() {
		int N = 5;
		int[] V = new int[] { 10, 2, 8, 6, 4 };
		int C = 5;
		double S = 0.01;
		assertEquals(24.327358, new MissingMail().getMaxExpectedProfit(N, V, C, S), 0);
	}

}
