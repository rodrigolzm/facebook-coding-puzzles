package level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KaitenzushiTest {

	@Test
	public void Test1() {
		int N = 6;
		int[] D = new int[] { 1, 2, 3, 3, 2, 1 };
		int K = 1;
		assertEquals(5, new Kaitenzushi().getMaximumEatenDishCount(N, D, K));
	}

	@Test
	public void Test2() {
		int N = 6;
		int[] D = new int[] { 1, 2, 3, 3, 2, 1 };
		int K = 2;
		assertEquals(4, new Kaitenzushi().getMaximumEatenDishCount(N, D, K));
	}

	@Test
	public void Test3() {
		int N = 7;
		int[] D = new int[] { 1, 2, 1, 2, 1, 2, 1 };
		int K = 2;
		assertEquals(2, new Kaitenzushi().getMaximumEatenDishCount(N, D, K));
	}

}
