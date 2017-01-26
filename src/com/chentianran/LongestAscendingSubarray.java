package com.chentianran;

/**
 * Created by Tianran on 1/22/2017.
 */
public class LongestAscendingSubarray {
	public int longestLength(int[] input) {
		if(input == null || input.length == 0) {
			return 0;
		}
		int cur = 1;
		int result = 1;
		for(int i = 1; i < input.length; i++) {
			if(input[i] > input[i-1]) {
				cur++;
				result = Math.max(result, cur);
			} else {
				cur = 1;
			}
		}
		return result;
	}

	public int[] longestIndices(int[] input) {
		if (input == null || input.length == 0) {
			 return new int[] {-1, -1};
		}
		int cur = 1;
		int max = 1;
		int curStart = 0;
		int maxStart = 0;
		int maxEnd = 0;

		for(int i = 1; i < input.length; i++) {
			if(input[i] > input[i-1]) {
				cur++;
			} else {
				cur = 1;
				curStart = i;
			}
			if(cur > max) {
				max = cur;
				maxStart = curStart;
				maxEnd = i;
			}
		}
		return new int[] {maxStart, maxEnd};
	}
}
