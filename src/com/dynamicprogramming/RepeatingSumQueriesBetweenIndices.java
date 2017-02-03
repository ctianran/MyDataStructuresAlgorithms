package com.dynamicprogramming;

/**
 * Created by Tianran on 2/2/2017.
 */
public class RepeatingSumQueriesBetweenIndices {
	public void repeatingQueriesI(int[] input) {
		//queries the sum between i and j, i <= j
		if(input == null || input.length == 0) {
			return;
		}
		int size = input.length;
		int[][] matrix = new int[size][size];

		for(int i = 0; i < size; i++) {
			for(int j = i; j < size; j++) {
				//base case
				if(i == j) {
					matrix[i][j] = input[j];
				} else {
					matrix[i][j] = matrix[i][j-1] + input[j];
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int repeatingQueriesII(int[] input, int left, int right) {
		//assume left <= right
		if(input == null || input.length == 0) {
			return Integer.MIN_VALUE;
		}
		int[] prefixSum = new int[input.length];
		prefixSum[0] = input[0];
		for(int i = 1; i < input.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + input[i];
		}
		return prefixSum[right] - prefixSum[left] + input[left];
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 3};
		RepeatingSumQueriesBetweenIndices sol = new RepeatingSumQueriesBetweenIndices();
		sol.repeatingQueriesI(input);
		int res = sol.repeatingQueriesII(input, 1,2);
		System.out.println(res);
	}
}
