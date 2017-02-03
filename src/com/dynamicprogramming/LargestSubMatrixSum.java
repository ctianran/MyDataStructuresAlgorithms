package com.dynamicprogramming;

/**
 * Created by Tianran on 2/2/2017.
 */
public class LargestSubMatrixSum {
	public int largestI(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int result = Integer.MIN_VALUE;

		for(int i = 0; i < rows; i++) {
			int[] cur = new int[cols];
			for(int j = i; j < rows; j++) {
				for(int k = 0; k < cols; k++) {
					cur[k] += matrix[j][k];
				}
				result = Math.max(result, helper(cur));
			}
		}
		return result;
	}

	private int helper(int[] array) {
		int cur = array[0];
		int result = array[0];
		for(int i = 0; i < array.length; i++) {
			cur = Math.max(array[i], cur + array[i]);
			result = Math.max(result, cur);
		}
		return result;
	}

	/*public int largestII(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] subSum = new int[rows][cols];

		subSum[0][0] = matrix[0][0];
		for(int i = 1; i < cols; i++) {
			subSum[0][i] = subSum[0][i-1] + matrix[0][i];
		}
		for(int i = 1; i < rows; i++) {
			int sumRowSoFar = 0;
			for(int j = 0; j < cols; j++) {
				sumRowSoFar += matrix[i][j];
				subSum[i][j] = subSum[i-1][j] + sumRowSoFar;
			}
		}
		int result = Integer.MIN_VALUE;
		int cur = subSum[0][0];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				for(int k = 1; k < i; k++) {
					for(int t = 1; t < j; t++) {
						if(i == 0 || j == 0) {
							cur = subSum[i][j];
						} else {
							cur = subSum[i][j] - subSum[k - 1][j] - subSum[i][t - 1] + subSum[k - 1][t - 1];
						}
					}
				}
			}*//**//*

	}*/

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,-2,-1,4},{1,-1,1,1},{0,-1,-1,1},{0,0,1,1}};
		LargestSubMatrixSum sol = new LargestSubMatrixSum();
		int res = sol.largestI(matrix);
		System.out.println(res);
	}
}
