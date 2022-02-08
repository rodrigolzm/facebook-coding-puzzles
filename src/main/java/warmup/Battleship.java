package warmup;

public class Battleship {

	public double getHitProbability(int R, int C, int[][] G) {
		double s = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (G[i][j] == 1)
					s++;
			}
		}
		return s / (R * C);
	}

}
