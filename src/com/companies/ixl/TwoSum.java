package com.companies.ixl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 8/18/2017.
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[]{-1, -1};
	}

	public boolean existTwoSum(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return false;
		}
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int sum = nums[left] + nums[right];
			if(sum == target) {
				return true;
			} else if(sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 5, 8};
		TwoSum sol = new TwoSum();
		int[] res = sol.twoSum(nums, 6);
		System.out.println(res[0] + " " + res[1]);
	}


}
