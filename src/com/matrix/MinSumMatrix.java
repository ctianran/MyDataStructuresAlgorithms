package com.matrix;

/**
 * Created by Tianran on 3/10/2017.
 */
public class MinSumMatrix {
	public int[][] minSumMatrix(int[][] matrix, int m) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return matrix;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] prefixSum = new int[rows + 1][cols + 1];
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= cols; j++) {
				prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + matrix[i-1][j-1];
			}
		}
		printMatrix(prefixSum);

		int min = Integer.MAX_VALUE;
		int iMin = 0;
		int jMin = 0;

		for(int i = m; i <= rows; i++) {
			for(int j = m; j <= cols; j++) {
				int cur = prefixSum[i][j] - prefixSum[i-m][j] - prefixSum[i][j-m] + prefixSum[i-m][j-m];
				if(cur < min) {
					min = cur;
					iMin = i - 1;
					jMin = j - 1;
				}
			}
		}
		int[][] result = new int[m][m];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				result[i][j] = matrix[iMin - m + 1 + i][jMin - m + 1 + j];
			}
		}
		return result;
	}

	private static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {{4,1,2},
						                     {1,2,3},
						                     {2,1,2}};
		MinSumMatrix sol = new MinSumMatrix();
		int[][] res = sol.minSumMatrix(input, 2);
		printMatrix(res);
	}
}
