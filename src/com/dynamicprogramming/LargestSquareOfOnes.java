package com.dynamicprogramming;

/**
 * Created by Tianran on 2/2/2017.
 */
public class LargestSquareOfOnes {
	public int largestSquare(int[][] matrix) {
		//assume matrix size is N * N
		int[][] dp = new int[matrix.length][matrix.length];
		int result = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = matrix[i][j];
				} else if(matrix[i][j] == 1) {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {{1,0,0,1},{1,1,1,0},{1,1,0,1},{1,1,1,0}};

		LargestSquareOfOnes sol = new LargestSquareOfOnes();
		int res = sol.largestSquare(input);
		System.out.println(res);
	}
}
