package com.arrays;

import java.util.TreeSet;

/**
 * Created by Tianran on 3/5/2017.
 */
public class SubArraySumClosestToTarget {
	public int closest(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return Integer.MAX_VALUE;
		}
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(0);
		int sum = 0;
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int temp = sum - target;
			if(treeSet.floor(temp) != null) {
				int low = treeSet.floor(temp);
				if(Math.abs(result - target) > Math.abs(target - (sum - low))) {
					result = sum - low;
				}
			}
			if(treeSet.ceiling(temp) != null) {
				int high = treeSet.ceiling(temp);
				if(Math.abs(result - target) > Math.abs(target - (sum - high))) {
					result = sum - high;
				}
			}
			treeSet.add(sum);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 5};
		SubArraySumClosestToTarget sol = new SubArraySumClosestToTarget();
		int res = sol.closest(nums, 2);
		System.out.println(res);
	}
}
