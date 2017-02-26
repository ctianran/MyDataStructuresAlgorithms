package com.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/25/2017.
 */
public class DivisibleSubArray {
	public int[] divisibleSubArrayI(int[] nums, int divisor) {
		if(nums == null || nums.length == 0 || divisor == 0) {
			return new int[] {-1, -1};
		}
		for(int i = 0; i < nums.length; i++) {
			int sum = 0;
			for(int j = i; j < nums.length; j++) {
				sum += nums[j];
				if(sum % divisor == 0) {
					return new int[] {i, j};
				}
			}
		}
		return new int[] {-1, -1};
	}

	public int[] divisibleSubArrayII(int[] nums, int divisor) {
		if(nums == null || nums.length == 0 || divisor == 0) {
			return new int[] {-1, -1};
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int modVal = mod(sum, divisor);
			if(map.containsKey(modVal)) {
				return new int[] {map.get(modVal) + 1, i};
			} else {
				map.put(modVal, i);
			}
		}
		return new int[] {-1, -1};
	}

	private int mod(int a, int b) {
		int res = a % b;
		return res < 0 ? res + b : res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {-1, 6, -3, 4, -5};
		DivisibleSubArray sol = new DivisibleSubArray();
		int[] res = sol.divisibleSubArrayII(nums, 5);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
