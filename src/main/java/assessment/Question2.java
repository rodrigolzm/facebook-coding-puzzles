package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * You have been given a task of reordering some data from a log file. In the
 * log file, every line is a space-delimited list of strings; <b>all lines begin
 * with an alphanumeric identifier</b>. There will be no lines consisting only
 * of an identifier. After the alphanumeric identifier, a line will consist of
 * either:<br>
 * - a list of words using only lower-case English letters<br>
 * - or a list of only integers<br>
 * <p>
 * You have to reorder the data such that all of the lines with words are at the
 * top of the log file. The lines with words are ordered lexicographically,
 * ignoring the identifier except in the case of ties. In case of ties (if there
 * are two lines that are identical except for the identifier), the identifier
 * is used to order lexicographically. Alphanumeric should be sorted in ASCII
 * order (numbers come before letters). The identifiers must still be part of
 * the line in the output strings. Lines with integers must be left in the
 * original order they were in the file.
 * <p>
 * Write an algorithm to reorder the data in the log file, according to the
 * rules above.
 * <p>
 * Input<br>
 * The input to the function/method consists of two arguments:<br>
 * logFileSize - an integer representing the number of log lines<br>
 * logLines - a list of strings representing the log file<br>
 * <p>
 * Output<br>
 * Return a list of strings representing the reordered log file data.<br>
 * <p>
 * Note<br>
 * Identifier consists of only lower case English character and numbers.
 * <p>
 * Example
 * <p>
 * Input: logFileSize = 5<br>
 * logLines = <br>
 * [a1 9 2 3 1]<br>
 * [g1 act car]<br>
 * [zo4 4 7]<br>
 * [ab1 off key dog]<br>
 * [a8 act zoo]<br>
 * <p>
 * Output:<br>
 * [g1 act car]<br>
 * [a8 act zoo]<br>
 * [ab1 off key dog]<br>
 * [a1 9 2 3 1]<br>
 * [zo4 4 7]<br>
 * <p>
 * Explanation:<br>
 * Second, fourth, and fifth lines are the lines with words. According to the
 * lexicographical order, the second line will be reordered first in the log
 * file, then fifth, and fourth comes in the log file. Next, the lines with
 * numbers come in the order in which these lines were in the input.
 */
public class Question2 {

	public List<String> reorderLines(int logFileSize, List<String> logLines) {
		
		TreeMap<Integer, String> integerLines = new TreeMap<Integer, String>();
		TreeMap<String, TreeSet<String>> wordLines = new TreeMap<String, TreeSet<String>>();
		
		for (int i = 0; i < logFileSize; i++) {
			String[] parts = logLines.get(i).split(" ");
			
			boolean isInteger = false;
			try {
				Integer.valueOf(parts[1]);
				isInteger = true;
			} catch (NumberFormatException e) {
			}
			
			if (isInteger) {
				integerLines.put(i, logLines.get(i));
			} else {
				int index = logLines.get(i).indexOf(" ");
				String log = logLines.get(i).substring(index + 1);
				if (!wordLines.containsKey(log)) {
					wordLines.put(log, new TreeSet<String>());
				}
				wordLines.get(log).add(parts[0]);
			}
		}
		
		List<String> result = new ArrayList<String>();
		
		while (!wordLines.isEmpty()) {
			String line = wordLines.firstEntry().getValue().first() + " " + wordLines.firstEntry().getKey();
			result.add(line);
			wordLines.firstEntry().getValue().remove(wordLines.firstEntry().getValue().first());
			if (wordLines.firstEntry().getValue().isEmpty()) {
				wordLines.pollFirstEntry();
			}
		}
		
		result.addAll(integerLines.values());
		
		return result;
	}

}
