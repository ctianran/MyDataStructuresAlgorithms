package com.dynamicprogramming;

/**
 * Created by Tianran on 2/2/2017.
 */
public class LargestSquareSurroundedByOne {
	public int largestSquare(int[][] matrix) {
		if(matrix == null || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] left = new int[rows][cols];
		int[][] up = new int[rows][cols];

		//pre-process the left and up matrix
		//by counting the consecutive ones
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(i == 0 || j == 0) {
					left[i][j] = matrix[i][j];
					up[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1){
					left[i][j] = left[i][j - 1] + 1;
					up[i][j] = up[i-1][j] + 1;
				}
			}
		}

		int result = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				int length = Math.min(left[i][j], up[i][j]);
				for(int k = length; k >= 1;k--) {
					if(left[i-k+1][j] >= k && up[i][j-k+1] >= k) {
						result = Math.max(result, k);
						break;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {{1,0,1,1,1},{1,1,1,1,1},{1,1,0,1,0},{1,1,1,1,1},{1,1,1,0,0}};
		LargestSquareSurroundedByOne sol = new LargestSquareSurroundedByOne();
		int res = sol.largestSquare(input);
		System.out.println(res);
	}
}
