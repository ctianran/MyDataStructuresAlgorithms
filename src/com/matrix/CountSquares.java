package com.matrix;

/**
 * Created by Tianran on 2/16/2017.
 */
public class CountSquares {
	public int count(int m, int n) {
		if(m <= 0|| n <= 0) {
			return 0;
		}
		int sum = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; i + k < m && j + k < n; k++) {
					sum++;
				}
			}
		}
		return sum;
	}

	public int countII(int m , int n) {
		if(m <= 0 || m <= 0) {
			return 0;
		}
		int min = Math.min(m, n);
		int sum = 0;
		for(int len = 1; len <= min; len++) {
			int x = m - len + 1;
			int y = n - len + 1;
			sum += x * y;
		}
		return sum;
	}
	// not valid if matrix[i][j] == 1
	public int countSquares(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows + 1][cols + 1];
		int result = 0;
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= cols; j++) {
				if(matrix[i-1][j-1] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
					result += dp[i][j];
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{0, 0, 0, 0},
						                      {0, 0, 1, 0},
						                      {0, 0, 1, 0}};
		CountSquares sol = new CountSquares();
		int res = sol.count(6, 7);
		int res2 = sol.countSquares(matrix);
		System.out.println(res);
		System.out.println(res2);
	}
}
