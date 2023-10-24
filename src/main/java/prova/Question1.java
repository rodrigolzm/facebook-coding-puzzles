package prova;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * <pre>
 *       4    
 *     /   \  
 *    2     6 
 *   / \   /  
 *  3   5 1   
 * </pre>
 * Output:
 * <p>
 * [4, 2, 1]
 * 
 * @author rodrigolzm
 */
public class Question1 {
	
	public static int[] solution(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(root.data);
		
		if (root.children != null) {
			min(root.children, 1, result);
		}
		
		int[] output = new int[result.size()];
		for (int i = 0; i < output.length; i++)
			output[i] = result.get(i);
		
		return output;
	}
	
	private static void min(List<Node> nodes, int level, List<Integer> result) {
		if (nodes != null) {
			if (level >= result.size()) 
				result.add(Integer.MAX_VALUE);
			
			for (Node node : nodes) {
				result.set(level, Math.min(result.get(level), node.data));
				min(node.children, level + 1, result);
			}
		}
	}
	
}
