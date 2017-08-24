package com.companies.ixl;

/**
 * Created by Tianran on 8/18/2017.
 */
public class UniquePathII {
	public int uniquePathWithObstacles(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int rows = grid.length;
		int cols = grid[0].length;
		int[] dp = new int[cols];
		for(int i = 0; i < cols; i++) {
			if(grid[0][i] == 0) {
				dp[i] = 1;
			} else {
				break;
			}
		}

		for(int i = 1; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 1) {
					dp[j] = 0;
				} else {
					if(j != 0) {
						dp[j] += dp[j-1];
					}
				}
			}
		}
		return dp[cols - 1];
	}
}
