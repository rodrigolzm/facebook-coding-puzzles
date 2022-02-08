package level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectorofPhotography1Test {

	@Test
	public void Test1() {
		int N = 5;
		String C = "APABA";
		int X = 1;
		int Y = 2;
		assertEquals(1, new DirectorofPhotography1().getArtisticPhotographCount(N, C, X, Y));
	}
	
	@Test
	public void Test2() {
		int N = 5;
		String C = "APABA";
		int X = 2;
		int Y = 3;
		assertEquals(0, new DirectorofPhotography1().getArtisticPhotographCount(N, C, X, Y));
	}
	
	@Test
	public void Test3() {
		int N = 8;
		String C = ".PBAAP.B";
		int X = 1;
		int Y = 3;
		assertEquals(3, new DirectorofPhotography1().getArtisticPhotographCount(N, C, X, Y));
	}

}
