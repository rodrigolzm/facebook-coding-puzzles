package level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HopsTest {

	@Test
	public void Test1() {
		int N = 3;
		int F = 1;
		long[] P = new long[] { 1 };
		assertEquals(2, new Hops().getSecondsRequired(N, F, P));
	}
	
	@Test
	public void Test2() {
		int N = 6;
		int F = 3;
		long[] P = new long[] { 5, 2, 4 };
		assertEquals(4, new Hops().getSecondsRequired(N, F, P));
	}
	
	@Test
	public void Test3() {
		int N = 6;
		int F = 2;
		long[] P = new long[] { 1, 4 };
		assertEquals(5, new Hops().getSecondsRequired(N, F, P));
	}

}
