package com.dynamicprogramming;

/**
 * Created by Tianran on 2/2/2017.
 */
public class LargestXCrossOnes {
	public int largestXCross(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] leftDown = new int[rows][cols];
		int[][] rightDown = new int[rows][cols];
		int[][] leftUp = new int[rows][cols];
		int[][] rightUp = new int[rows][cols];
		//build left down matrix
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(i == 0 || j == 0) {
					leftDown[i][j] = matrix[i][j];
				} else if(matrix[i][j] == 1) {
					leftDown[i][j] = leftDown[i-1][j-1] + 1;
				}
			}
		}
		//printMatrix(leftDown);
		//build right down matrix
		for(int i = 0; i < rows; i++) {
			for(int j = cols - 1; j >= 0; j--) {
				if(i == 0 || j == cols - 1) {
					rightDown[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					rightDown[i][j] = rightDown[i-1][j+1] + 1;
				}
			}
		}
		//printMatrix(rightDown);
		//build left up matrix
		for(int i = rows - 1; i >= 0; i--) {
			for(int j = 0; j < cols; j++) {
				if(i == rows - 1 || j == 0) {
					leftUp[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					leftUp[i][j] = leftUp[i + 1][j - 1] + 1;
				}
			}
		}
		//printMatrix(leftUp);
		//build right up matrix
		for(int i = rows - 1; i >= 0; i--) {
			for(int j = cols - 1; j >= 0; j--) {
				if(i == rows - 1 || j == cols - 1) {
					rightUp[i][j] = matrix[i][j];
				} else if(matrix[i][j] == 1) {
					rightUp[i][j] = rightUp[i+1][j+1] + 1;
				}
			}
		}
		//printMatrix(rightUp);
		//check each position to find the min value, and update global max
		int cur = 0;
		int result = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				cur = Math.min(Math.min(leftDown[i][j], rightDown[i][j]), Math.min(leftUp[i][j],rightUp[i][j]));
				result = Math.max(result, cur);
			}
		}
		return result;
	}

	private void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {{1,0,1,0},{0,1,0,1},{1,0,1,0},{0,1,0,0}};
		LargestXCrossOnes sol = new LargestXCrossOnes();
		int res = sol.largestXCross(input);
		System.out.println(res);
	}
}
