package com.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LongestSubArrayEqualsTarget {
	public int longest(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int result = 0;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int temp = sum - target;
			if(map.containsKey(temp)) {
				result = Math.max(result, i - map.get(temp));
			}
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return result;
	}
}
