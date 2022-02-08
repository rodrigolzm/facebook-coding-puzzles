package level2;

/**
 * Portals
 * <p>
 * You've found yourself in a grid of cells with R rows and C columns. The cell
 * in the ith row from the top and jth column from the left contains one of the
 * following (indicated by the character Gi,j):
 * <p>
 * If Gi,j = ".", the cell is empty.<br>
 * If Gi,j = "S", the cell contains your starting position. There is exactly one
 * such cell.<br>
 * If Gi,j = "E", the cell contains an exit. There is at least one such
 * cell.<br>
 * If Gi,j = "#", the cell contains a wall.<br>
 * Otherwise, if Gi,j is a lowercase letter (between "a" and "z", inclusive),
 * the cell contains a portal marked with that letter.<br>
 * <p>
 * Your objective is to reach any exit from your starting position as quickly as
 * possible. Each second, you may take either of the following actions:
 * <p>
 * Walk to a cell adjacent to your current one (directly above, below, to the
 * left, or to the right), as long as you remain within the grid and that cell
 * does not contain a wall.
 * <p>
 * If your current cell contains a portal, teleport to any other cell in the
 * grid containing a portal marked with the same letter as your current cell's
 * portal.
 * <p>
 * Determine the minimum number of seconds required to reach any exit, if it's
 * possible to do so at all. If it's not possible, return −1 instead.
 * <p>
 * Constraints
 * <p>
 * 1 ≤ R,C ≤ 50<br>
 * Gi,j ∈ {".", "S", "E", "#", "a"..."z"}<br>
 * <p>
 * Sample test case #1<br>
 * R = 3<br>
 * C = 3<br>
 * G = .E.<br>
 *     .#E<br>
 *     .S#<br>
 * Expected Return Value = 4<br>
 * <p>
 * Sample test case #2<br>
 * R = 3<br>
 * C = 4<br>
 * G = a.Sa<br>
 *     ####<br>
 *     Eb.b<br>
 * Expected Return Value = -1<br>
 * <p>
 * Sample test case #3<br>
 * R = 3<br>
 * C = 4<br>
 * G = aS.b<br>
 *     ####<br>
 *     Eb.a<br>
 * Expected Return Value = 4<br>
 * <p>
 * Sample test case #4<br>
 * R = 1<br>
 * C = 9<br>
 * G = xS..x..Ex<br>
 * Expected Return Value = 3<br>
 * <p>
 * Sample Explanation
 * <p>
 * In the first case, you can reach an exit in 4 seconds by walking left once,
 * then up twice, and then finally right once.
 * <p>
 * In the second case, you can never reach the exit.
 * <p>
 * In the third case, you should walk right twice, then teleport to the cell in
 * the 3rd row and 2nd column, and finally walk left once.
 * <p>
 * In the fourth case, you should walk left once, teleport to the cell in the
 * last column, and walk left once more.
 */
public class Portals {

	public int getSecondsRequired(int R, int C, char[][] G) {
		// Write your code here
		return 0;
	}

}
