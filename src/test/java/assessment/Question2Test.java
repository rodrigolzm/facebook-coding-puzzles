package assessment;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class Question2Test {

	@Test
	public void Test1() {
		int logFileSize = 5;
		String[] logLines = new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };
		assertArrayEquals(new String[] { "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7" },
				new Question2().reorderLines(logFileSize, Arrays.asList(logLines)).toArray());
	}

	@Test
	public void Test2() {
		int logFileSize = 4;
		String[] logLines = new String[] { "mi2 jog mid pet", "wz3 34 54 398", "a1 alps cow bar", "x4 45 21 7" };
		assertArrayEquals(new String[] { "a1 alps cow bar", "mi2 jog mid pet", "wz3 34 54 398", "x4 45 21 7" },
				new Question2().reorderLines(logFileSize, Arrays.asList(logLines)).toArray());
	}

	@Test
	public void Test3() {
		int logFileSize = 6;
		String[] logLines = new String[] { "t2 13 121 98", "br8 eat nim did", "b4 xi me nu", "w1 has uni gry",
				"r1 box ape bit", "f3 52 54 31" };
		assertArrayEquals(new String[] { "r1 box ape bit", "br8 eat nim did", "w1 has uni gry", "b4 xi me nu",
				"t2 13 121 98", "f3 52 54 31" },
				new Question2().reorderLines(logFileSize, Arrays.asList(logLines)).toArray());
	}
}
