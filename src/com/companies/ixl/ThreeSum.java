package com.companies.ixl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 8/18/2017.
 */
public class ThreeSum {
	public boolean exist(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return false;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if(sum == target) {
					return true;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return false;
	}

	public List<List<Integer>> threeSumAllUnique(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
				if(i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int left = i + 1;
				int right = nums.length - 1;
				while(left < right) {
					int sum = nums[i] + nums[left] + nums[right];
					if(sum == target) {
						res.add(Arrays.asList(nums[i], nums[left], nums[right]));
						left++;
						right--;
					}
					//skip the same element from left
					while(left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					//skip the same element from right
					while(left < right && nums[right] == nums[right + 1]) {
						right--;
					}
					if(sum < target) {
						left++;
					} else {
						right--;
					}
				}
		}
		return res;
	}
}
