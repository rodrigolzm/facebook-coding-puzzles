package assessment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Rodrigo {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];

		for (int i = 0; i < nums1.length; i++) {
			nums[i] = nums1[i];
		}

		for (int i = 0; i < nums2.length; i++) {
			nums[nums1.length + i] = nums2[i];
		}

		Arrays.sort(nums);

		int index = nums.length / 2;
		int remaining = nums.length % 2;

		double median = nums[index];
		if (remaining == 0)
			median = (median + nums[index - 1]) / 2;

		return median;
	}

	@Test
	public void Test1() {
		int[] a = new int[] { 1, 3 };
		int[] b = new int[] { 2 };
		assertEquals(2, new Rodrigo().findMedianSortedArrays(a, b), 0);
	}
	
	@Test
	public void Test2() {
		int[] a = new int[] { 1, 2 };
		int[] b = new int[] { 3, 4 };
		assertEquals(2.5, new Rodrigo().findMedianSortedArrays(a, b), 0);
	}

}
