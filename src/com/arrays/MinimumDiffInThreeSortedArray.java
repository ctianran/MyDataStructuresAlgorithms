package com.arrays;

/**
 * Created by Tianran on 3/1/2017.
 */
public class MinimumDiffInThreeSortedArray {
	public int minDiff(int[] A, int[] B, int [] C) {
		int i = 0;
		int j = 0;
		int k = 0;
		int result = Integer.MAX_VALUE;
		while(i < A.length && j < B.length && k < C.length) {
			int min = Math.abs(A[i] - B[j]) + Math.abs(B[j] - C[k]) + Math.abs(A[i] - C[k]);
			result = Math.min(result, min);
			if(A[i] <= B[j] && A[i] <= C[k]) {
				i++;
			} else if (B[j] <= C[k] && B[j] <= A[i]) {
				j++;
			} else {
				k++;
			}
		}
		return result;
	}
}
