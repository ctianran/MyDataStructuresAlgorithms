package com.companies.ixl;

import java.util.Arrays;

/**
 * Created by Tianran on 8/13/2017.
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] minCount = new int[] {Integer.MAX_VALUE};
		helper(coins, amount, 0, 0, minCount);
		return minCount[0] == Integer.MAX_VALUE ? -1 : minCount[0];
	}

	private void helper(int[] coins, int amount, int index, int curCount, int[] minCount) {
		if(amount == 0) {
			minCount[0] = Math.min(curCount, minCount[0]);
			return;
		}
		if(index == coins.length) {
			return;
		}
		for(int i = 0; i <= amount/coins[index]; i++) {
			helper(coins, amount - i * coins[index], index + 1, curCount + i, minCount);
		}
	}

	public int coinChangeII(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int coin : coins) {
			for(int i = coin; i <= amount; i++) {
				if(dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i-coin] + 1);
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = new int[] {1, 2, 5};
		CoinChange sol = new CoinChange();
		int res = sol.coinChangeII(coins, 11);
		System.out.println(res);
	}
}
