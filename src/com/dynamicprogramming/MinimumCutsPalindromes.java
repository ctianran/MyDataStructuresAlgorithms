package com.dynamicprogramming;

/**
 * Created by Tianran on 3/17/2017.
 */
public class MinimumCutsPalindromes {

	//Time: O(n^3)  with O(n) validation
	public int minCuts(String s) {
		if(s == null || s.length() == 0) {
			return -1;
		}
		if(s.length() == 1) {
			return 0;
		}
		int[] dp = new int[s.length()];
		for(int i = 0; i < s.length(); i++) {
			dp[i] = i;
			if(isPal(s, 0, i)) {
				dp[i] = 0;
			} else {
				for(int j = i - 1; j >= 0; j--) {
					if(isPal(s, j + 1, i)) {
						dp[i] = Math.min(dp[i], dp[j] + 1);
					}
				}
			}
		}
		return dp[s.length() - 1];
	}

	private boolean isPal(String s, int left, int right) {
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	//Time: O(n^2) with O(1) validation
	//Space: O(n^2)
	public int minCutsII(String s) {
			if(s == null || s.length() == 0) {
				return -1;
			}
			int len = s.length();
			if(len == 1) {
				return 0;
			}
			int[] dp = new int[len + 1];
			boolean[][] isPal = new boolean[len + 1][len + 1];
			for(int end = 1; end <= len; end++) {
				dp[end] = end;
				for(int start = end; start >= 1; start--) {
					if(s.charAt(start - 1) == s.charAt(end - 1)) {
						if(end - start <= 1) {
							isPal[start][end] = true;
						} else {
							isPal[start][end] = isPal[start + 1][end - 1];
						}

						if(isPal[start][end]) {
							dp[end] = Math.min(dp[end], 1 + dp[start - 1]);
						}
					}
				}
			}
			return dp[len] - 1;
	}

	public static void main(String[] args) {
		String s = "aab";
		MinimumCutsPalindromes sol = new MinimumCutsPalindromes();
		int res = sol.minCuts(s);
		int res2 = sol.minCutsII(s);
		System.out.println(res);
		System.out.println(res2);
	}
}
