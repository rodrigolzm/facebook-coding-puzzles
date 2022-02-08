package level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackStabilization1Test {

	@Test
	public void Test1() {
		int N = 5;
		int[] R = new int[] { 2, 5, 3, 6, 5 };
		assertEquals(3, new StackStabilization1().getMinimumDeflatedDiscCount(N, R));
	}
	
	@Test
	public void Test2() {
		int N = 3;
		int[] R = new int[] { 100, 100, 100 };
		assertEquals(2, new StackStabilization1().getMinimumDeflatedDiscCount(N, R));
	}
	
	@Test
	public void Test3() {
		int N = 4;
		int[] R = new int[] { 6, 5, 4, 3 };
		assertEquals(-1, new StackStabilization1().getMinimumDeflatedDiscCount(N, R));
	}
	
	@Test
	public void Test4() {
		int N = 1;
		int[] R = new int[] { 6 };
		assertEquals(0, new StackStabilization1().getMinimumDeflatedDiscCount(N, R));
	}

}
