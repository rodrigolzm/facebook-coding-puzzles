package warmup;

public class AllWrong {

	public String getWrongAnswers(int N, String C) {
		String result = "";
		for (char c : C.toCharArray()) {
			result += c == 'A' ? "B" : "A";
		}
		return result;
	}

}
