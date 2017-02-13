package com.dynamicprogramming;

/**
 * Created by Tianran on 2/12/2017.
 */
public class LongestAscendingSubArray {
	public int longestLength(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int cur = 1;
		int result = 1;
		for(int i = 1; i < array.length; i++) {
			if(array[i] > array[i-1]) {
				cur++;
				result = Math.max(result, cur);
			} else {
				cur = 1;
			}
		}
		return result;
	}

	public int[] longestIndices(int[] array) {
		if(array == null || array.length == 0) {
			return new int[] {-1, -1};
		}
		int cur = 1;
		int longest = 1;
		int start = 0;
		int end = 0;

		for(int i = 1; i < array.length; i++) {
			if(array[i] > array[i-1]) {
				cur++;
			} else {
				cur = 1;
			}
			if(cur > longest) {
				longest = cur;
				start = i - longest + 1;
				end = i;
			}
		}
		return new int[] {start, end};
	}

	public static void main(String[] args) {
		int[] array = new int[] {7, 2, 3, 1, 5, 8, 9, 6};
		LongestAscendingSubArray sol = new LongestAscendingSubArray();
		int res = sol.longestLength(array);
		int[] res1 = sol.longestIndices(array);
		System.out.println(res);
		System.out.print(res1[0] + " " + res1[1]);
	}
}
