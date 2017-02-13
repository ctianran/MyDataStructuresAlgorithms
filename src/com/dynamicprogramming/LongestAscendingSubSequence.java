package com.dynamicprogramming;

/**
 * Created by Tianran on 2/12/2017.
 */
public class LongestAscendingSubSequence {
	public int longestI(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int result = 1;
		int[] dp = new int[array.length];
		dp[0] = 1;
		for(int i = 1; i < array.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(array[j] < array[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}

	public int longestII(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int result = 1;
		int[] temp = new int[array.length + 1];
		temp[1] = array[0];

		for(int i = 1; i < array.length; i++) {
			int index = getLargestSmaller(temp, 1, result, array[i]);
			if(index == result) {
				temp[++result] = array[i];
			} else {
				temp[index + 1] = array[i];
			}
		}
		return result;
	}

	private int getLargestSmaller(int[] temp, int left, int right, int target) {
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(temp[mid] <= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 4, 3, 7, 6, 4, 5};
		LongestAscendingSubSequence sol = new LongestAscendingSubSequence();
		int res1 = sol.longestI(input);
		int res2 = sol.longestII(input);
		System.out.println(res1);
		System.out.println(res2);
	}
}
