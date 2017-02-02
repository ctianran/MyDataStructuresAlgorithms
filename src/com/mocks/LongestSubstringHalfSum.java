package com.mocks;

/**
 * Created by Tianran on 2/2/2017.
 */
public class LongestSubstringHalfSum {
	public int longestSum(String input) {
		if(input == null || input.length() <= 1) {
			return 0;
		}
		int half = 0;
		for(int i = 1; i < input.length(); i++) {
			int left = 0;
			int right = 0;
			for(int j = 0; i - j - 1 >= 0 && i + j < input.length(); j++) {
				left += (input.charAt(i - j - 1) - '0');
				right += (input.charAt(i + j) - '0');

				if(left == right) {
					half = Math.max(half, j + 1);
				}
			}
		}
		return half * 2;
	}

	public static void main(String[] args) {
		String input = "1233121";

		LongestSubstringHalfSum sol = new LongestSubstringHalfSum();
		int res = sol.longestSum(input);
		System.out.println(res);
	}
}
