package level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PortalsTest {

	@Test
	public void Test1() {
		int R = 3;
		int C = 3;
		char[][] G = new char[][] { { '.', 'E', '.' }, { '.', '#', 'E' }, { '.', 'S', '#' } };
		assertEquals(4, new Portals().getSecondsRequired(R, C, G));
	}

	@Test
	public void Test2() {
		int R = 3;
		int C = 4;
		char[][] G = new char[][] { { 'a', '.', 'S', 'a' }, { '#', '#', '#', '#' }, { 'E', 'b', '.', 'b' } };
		assertEquals(-1, new Portals().getSecondsRequired(R, C, G));
	}

	@Test
	public void Test3() {
		int R = 3;
		int C = 4;
		char[][] G = new char[][] { { 'a', 'S', '.', 'b' }, { '#', '#', '#', '#' }, { 'E', 'b', '.', 'a' } };
		assertEquals(4, new Portals().getSecondsRequired(R, C, G));
	}

	@Test
	public void Test4() {
		int R = 1;
		int C = 9;
		char[][] G = new char[][] { { 'x', 'S', '.', '.', 'x', '.', '.', 'E', 'x' } };
		assertEquals(3, new Portals().getSecondsRequired(R, C, G));
	}

}
