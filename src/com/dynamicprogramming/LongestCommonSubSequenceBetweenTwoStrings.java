package com.dynamicprogramming;

/**
 * Created by Tianran on 2/12/2017.
 */
public class LongestCommonSubSequenceBetweenTwoStrings {
	//Time: O(m * n)
	//Space: O(m * n)
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

	//Time: O(m * n)
	//Space: O(n)
	public int longestLengthII(String s1, String s2) {
			if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
				return 0;
			}
			int[] prev = new int[s2.length() + 1];
			for(int i = 1; i <= s2.length(); i++) {
				if(s1.charAt(0) == s2.charAt(i-1)) {
					prev[i] = prev[i-1] + 1;
				}
			}
			int[] cur = new int[s2.length() + 1];
			for(int i = 1; i < s1.length(); i++) {
				for(int j = 1; j <= s2.length(); j++) {
					if(s1.charAt(i) == s2.charAt(j - 1)) {
						cur[j] = prev[j-1] + 1;
					} else {
						cur[j] = Math.max(prev[j], cur[j-1]);
					}
				}
				prev = cur;
			}
			return prev[s2.length()];
	}

	public static void main(String[] args) {
		String s1 = "sweden";
		String s2 = "student";
		LongestCommonSubSequenceBetweenTwoStrings sol = new LongestCommonSubSequenceBetweenTwoStrings();
		int res = sol.longestLength(s1, s2);
		int res2 = sol.longestLengthII(s1, s2);
		System.out.println(res);
		System.out.println(res2);
	}
}
