package com.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 3/5/2017.
 */
public class CountSubArrayEqualsTarget {
	public int count(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - target)) {
				count += map.get(sum - target);
			}
			if(!map.containsKey(sum)) {
				map.put(sum, 0);
			}
			map.put(sum, map.get(sum) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {3, -3, 3};
		CountSubArrayEqualsTarget sol = new CountSubArrayEqualsTarget();
		int res = sol.count(nums, 3);
		System.out.println(res);
	}
}
