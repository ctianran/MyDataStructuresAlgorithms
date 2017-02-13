package com.dynamicprogramming;

/**
 * Created by Tianran on 2/12/2017.
 */
public class LongestCommonSubSequenceBetweenTwoStrings {
	public int longestLength(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		int rows = s1.length();
		int cols = s2.length();
		int[][] dp = new int[rows + 1][cols + 1];

		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= cols; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[rows][cols];
	}

	public static void main(String[] args) {
		String s1 = "sweden";
		String s2 = "student";
		LongestCommonSubSequenceBetweenTwoStrings sol = new LongestCommonSubSequenceBetweenTwoStrings();
		int res = sol.longestLength(s1, s2);
		System.out.println(res);
	}
}
