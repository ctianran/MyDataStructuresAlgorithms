package com.dynamicprogramming;

/**
 * Created by Tianran on 2/2/2017.
 */
public class LongestConsecutiveOnes {
	public int longestOne(int[] input) {
		if(input == null || input.length == 0) {
			return -1;
		}
		int cur = 0;
		int result = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] == 0) {
				cur = 0;
			} else {
				cur++;
			}
			result = Math.max(result, cur);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,1,0,1,0,0,1,0,1,0,0,1,1,1,1,1,1,1};
		LongestConsecutiveOnes sol = new LongestConsecutiveOnes();
		int res = sol.longestOne(input);
		System.out.println(res);
	}
}
