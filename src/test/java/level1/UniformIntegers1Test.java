package level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UniformIntegers1Test {

	@Test
	public void Test1() {
		long A = 75l;
		long B = 300l;
		assertEquals(5, new UniformIntegers1().getUniformIntegerCountInInterval(A, B));
	}
	
	@Test
	public void Test2() {
		long A = 1l;
		long B = 9l;
		assertEquals(9, new UniformIntegers1().getUniformIntegerCountInInterval(A, B));
	}
	
	@Test
	public void Test3() {
		long A = 999999999999l;
		long B = 999999999999l;
		assertEquals(1, new UniformIntegers1().getUniformIntegerCountInInterval(A, B));
	}

}
