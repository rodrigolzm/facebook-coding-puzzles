package level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScoreboardInference1Test {

	@Test
	public void Test1() {
		int N = 6;
		int[] S = new int[] { 1, 2, 3, 4, 5, 6 };
		assertEquals(4, new ScoreboardInference1().getMinProblemCount(N, S));
	}

	@Test
	public void Test2() {
		int N = 4;
		int[] S = new int[] { 4, 3, 3, 4 };
		assertEquals(3, new ScoreboardInference1().getMinProblemCount(N, S));
	}

	@Test
	public void Test3() {
		int N = 4;
		int[] S = new int[] { 2, 4, 6, 8 };
		assertEquals(4, new ScoreboardInference1().getMinProblemCount(N, S));
	}
	
	@Test
	public void Test4() {
		int N = 1;
		int[] S = new int[] { 1 };
		assertEquals(1, new ScoreboardInference1().getMinProblemCount(N, S));
	}
	
	@Test
	public void Test5() {
		int N = 1;
		int[] S = new int[] { 2 };
		assertEquals(1, new ScoreboardInference1().getMinProblemCount(N, S));
	}

}
