package com.dynamicprogramming;

/**
 * Created by Tianran on 2/2/2017.
 */
public class LargestSubArraySum {
	public int largestSum(int[] input) {
		if(input == null || input.length == 0) {
			return Integer.MIN_VALUE;
		}
		int cur = input[0];
		int result = input[0];
		for(int i = 1; i < input.length; i++) {
			cur = Math.max(input[i], cur + input[i]);
			result = Math.max(result, cur);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {2, 1, -5, 4, 1};
		LargestSubArraySum sol = new LargestSubArraySum();
		int res = sol.largestSum(input);
		System.out.println(res);
	}
}
