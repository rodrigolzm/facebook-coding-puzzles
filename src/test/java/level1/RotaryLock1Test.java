package level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RotaryLock1Test {

	@Test
	public void Test1() {
		int N = 3;
		int M = 3;
		int[] C = {1, 2, 3};
		assertEquals(2, new RotaryLock1().getMinCodeEntryTime(N, M, C));
	}

	@Test
	public void Test2() {
		int N = 10;
		int M = 4;
		int[] C = {9, 4, 4, 8};
		assertEquals(11, new RotaryLock1().getMinCodeEntryTime(N, M, C));
	}
	
	@Test
	public void Test3() {
		int N = 4;
		int M = 4;
		int[] C = {1, 2, 1, 2};
		assertEquals(3, new RotaryLock1().getMinCodeEntryTime(N, M, C));
	}
	
	@Test
	public void Test4() {
		int N = 4;
		int M = 4;
		int[] C = {1, 1, 2, 1};
		assertEquals(2, new RotaryLock1().getMinCodeEntryTime(N, M, C));
	}

	@Test
	public void Test5() {
		int N = 4;
		int M = 4;
		int[] C = {1, 1, 1, 1};
		assertEquals(0, new RotaryLock1().getMinCodeEntryTime(N, M, C));
	}
	
	@Test
	public void Test6() {
		int N = 6;
		int M = 5;
		int[] C = {2, 5, 6, 3, 1};
		assertEquals(10, new RotaryLock1().getMinCodeEntryTime(N, M, C));
	}
}
