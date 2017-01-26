package com.chentianran;

/**
 * Created by Tianran on 1/22/2017.
 */
public class ArrayHopper {
	public boolean canReach(int[] input) {
		if(input == null || input.length == 0) {
			return false;
		}
		boolean[] dp = new boolean[input.length];
		dp[input.length - 1] = true;

		for(int i = input.length - 2; i >= 0; i--) {
			if(input[i] + i >= input.length - 1) {
				dp[i] = true;
			} else {
				for(int j = input[i]; j >= 1; j--) {
					if(dp[i + j]) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[0];
	}
}
