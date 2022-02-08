package level1;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class CafeteriaTest {

	@Test
	public void Test1() {
		int N = 10;
		int K = 1;
		int M = 2;
		long[] S = new long[] { 2, 6 };
		assertEquals(3, new Cafeteria().getMaxAdditionalDinersCount(N, K, M, S));
	}

	@Test
	public void Test2() {
		int N = 15;
		int K = 2;
		int M = 3;
		long[] S = new long[] { 11, 6, 14 };
		assertEquals(1, new Cafeteria().getMaxAdditionalDinersCount(N, K, M, S));
	}

	@Test
	public void Test3() {

		
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
		assertEquals(8, addTwoNumbers(n1, n2).val);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		while (l1 != null && l2 != null) {
			
			int sum = carry;
			
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			
			q.add(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0)
			q.add(carry);
		
		ListNode f = null;
        ListNode p = null;
        while(q.size() != 0)
        {
        	if (p == null) {
        		f = new ListNode(q.poll());
        		p = f;
        	} else {
        		p.next = new ListNode(q.poll());
        		p = p.next;
        	}
        }

        return f;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}