package prova;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


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
public class Question1Test {

	@Test
	public void test1() {
		Node root = new Node(4);
		
		Node n2 = new Node(2);
		n2.add(new Node(3));
		n2.add(new Node(5));
		
		Node n6 = new Node(6);
		n6.add(new Node(1));
		
		root.add(n2);
		root.add(n6);

		int[] result = Question1.solution(root);
		assertArrayEquals(new int[] {4, 2, 1}, result);
	}
	
}
