package com.chentianran;

/**
 * Created by Tianran on 1/18/2017.
 */
public class LongestSubArrayConsistsOneWithKFlips {
	public int[] longest(int[] input, int k) {
		if(input == null || input.length == 0) {
			return new int[] {-1, -1};
		}
		int slow = 0;
		int count = 0;
		int max = 0;
		int start = 0;
		int end = 0;
		for(int fast = 0; fast < input.length; fast++) {
			if(input[fast] == 0) {
				count++;
				while(count > k) {
					if(input[slow] == 0) {
						count--;
					}
					slow++;
				}
			}
			if(fast - slow > max) {
				max = fast - slow;
				start = slow;
				end = fast;
			}
		}
		return new int[] {start, end};
	}
}
