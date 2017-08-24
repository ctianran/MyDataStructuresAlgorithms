package com.companies.ixl;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Tianran on 8/18/2017.
 */
public class KthLargestElement {
  //sort the array
	//Time: O(nlogn)
	public int findKthLargest(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	//minHeap,
	//Time: O(nlogk)
	public int findKthLarget(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
		for(int i = 0; i < nums.length; i++) {
			if(i < k) {
				minHeap.offer(nums[i]);
			} else {
				if(minHeap.peek() < nums[i]) {
					minHeap.poll();
					minHeap.offer(nums[i]);
				}
			}
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		int[] nums = new int[] {2, 1};
		KthLargestElement sol = new KthLargestElement();
		int res = sol.findKthLargest(nums, 1);
		System.out.println(res);
	}
}
