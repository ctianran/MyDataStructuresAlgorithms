package com.dynamicprogramming;

/**
 * Created by Tianran on 2/12/2017.
 */
public class LongestCommonSubStringBetweenTwoStrings {
	public int longestLength(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		int rows = s1.length();
		int cols = s2.length();
		int[][] dp = new int[rows + 1][cols + 1];
		int result = Integer.MIN_VALUE;
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= cols; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}

	public String longestSubstring(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return null;
		}
		int rows = s1.length();
		int cols = s2.length();
		int[][] dp = new int[rows + 1][cols + 1];
		int start = 0;
		int longest = 0;
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= cols; j++) {
				if(s1.charAt(i-1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				if(dp[i][j] > longest) {
					longest = dp[i][j];
					start = i - longest; //char at i - 1,  i - 1 - longest + 1
				}
			}
		}
		return s1.substring(start, start + longest);
	}

	public static void main(String[] args) {
		String s1 = "sweden";
		String s2 = "student";
		LongestCommonSubStringBetweenTwoStrings sol = new LongestCommonSubStringBetweenTwoStrings();
		int res = sol.longestLength(s1, s2);
		String res2 = sol.longestSubstring(s1, s2);
		System.out.println(res);
		System.out.println(res2);
	}
}
