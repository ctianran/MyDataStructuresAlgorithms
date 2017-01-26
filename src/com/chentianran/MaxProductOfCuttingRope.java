package com.chentianran;

/**
 * Created by Tianran on 1/22/2017.
 */
public class MaxProductOfCuttingRope {
	public int maxProduct(int n) {
		if(n <= 1) {
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[1] = 0;
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i/2; j++) {
				dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i-j]));
			}
		}
		return dp[n];
	}
}
