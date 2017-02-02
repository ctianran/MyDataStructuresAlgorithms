package com.dynamicprogramming;

/**
 * Created by Tianran on 2/2/2017.
 */
public class LargestCrossOnes {
	public int largestCross(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] left = new int[rows][cols];
		int[][] right = new int[rows][cols];
		int[][] up = new int[rows][cols];
		int[][] down = new int[rows][cols];
		//build matrix for left to right, and up to down
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(i == 0 || j == 0) {
					left[i][j] = matrix[i][j];
					up[i][j] = matrix[i][j];
				} else if(matrix[i][j] == 1) {
					left[i][j] = left[i][j-1] + 1;
					up[i][j] = up[i-1][j] + 1;
				}
			}
		}
		//build matrix for right to left, and down to up
		for(int i = rows - 1; i >= 0; i--) {
			for(int j = cols - 1; j >= 0; j--) {
				if(i == rows - 1 || j == cols - 1) {
					right[i][j] = matrix[i][j];
					down[i][j] = matrix[i][j];
				} else if(matrix[i][j] == 1) {
					right[i][j] = right[i][j+1]  + 1;
					down[i][j] = down[i+1][j] + 1;
				}
			}
		}
		int result = 0;
		int cur = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				cur = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j]));
				result = Math.max(result, cur);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {{1,1,1,1,1},{1,0,1,0,0},{1,1,1,1,1},{1,0,1,0,0},{1,0,1,0,0}};

		LargestCrossOnes sol = new LargestCrossOnes();
		int res = sol.largestCross(input);
		System.out.println(res);
	}

}
