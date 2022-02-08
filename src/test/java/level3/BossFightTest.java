package level3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BossFightTest {

	@Test
	public void Test1() {
		int N = 3;
		int[] H = new int[] { 2, 1, 4 };
		int[] D = new int[] { 3, 1, 2 };
		int B = 4;
		assertEquals(6.5, new BossFight().getMaxDamageDealt(N, H, D, B), 0);
	}

	@Test
	public void Test2() {
		int N = 4;
		int[] H = new int[] { 1, 1, 2, 100 };
		int[] D = new int[] { 1, 2, 1, 3 };
		int B = 8;
		assertEquals(62.75, new BossFight().getMaxDamageDealt(N, H, D, B), 0);
	}

	@Test
	public void Test3() {
		int N = 4;
		int[] H = new int[] { 1, 1, 2, 3 };
		int[] D = new int[] { 1, 2, 1, 100 };
		int B = 8;
		assertEquals(62.75, new BossFight().getMaxDamageDealt(N, H, D, B), 0);
	}

	@Test
	public void Test4() {
		int N = 2;
		int[] H = new int[] { 1, 1 };
		int[] D = new int[] { 1, 1 };
		int B = 1;
		assertEquals(3, new BossFight().getMaxDamageDealt(N, H, D, B), 0);
	}
}
