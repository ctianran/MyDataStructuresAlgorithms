package com.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/24/2017.
 */
public class BinaryArrayLongestSpan {
	public int[] longestSpanI(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int[] sum = new int[2 * n + 1];
		for(int i = 0; i < sum.length; i++) {
			sum[i] = -1;
		}
		int sumA = 0;
		int sumB = 0;
		int longest = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for(int i = 0; i < n; i++) {
			sumA += arr1[i];
			sumB += arr2[i];
			int index = sumA - sumB + n;
			if(index == n) {
				if(longest < i + 1) {
					longest = i + 1;
					start = 0;
					end = i;
				}
			} else if (sum[index] != -1) {
				if(longest < i - sum[index]) {
					longest = i - sum[index];
					start = sum[index] + 1;
					end = i;
				}
			} else {
				sum[index] = i;
			}
		}
		return new int[] {start, end};
	}

	public int longestSpanII(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();
		int sumA = 0;
		int sumB = 0;
		int longest = Integer.MIN_VALUE;
		for(int i = 0; i < arr1.length; i++) {
			sumA += arr1[i];
			sumB += arr2[i];
			int diff = sumA - sumB;
			if(diff == 0) {
				longest = Math.max(longest, i + 1);
			} else if (map.containsKey(diff)) {
				int index = map.get(diff);
				longest = Math.max(longest, i - index);
			} else {
				map.put(diff, i);
			}
		}
		return longest;
	}
	public static void main(String[] args) {
		int[] arr1 = new int[] {0,1, 0, 0, 0};
		int[] arr2 = new int[] {1,0, 1, 0, 0};
		BinaryArrayLongestSpan sol = new BinaryArrayLongestSpan();
		int[] res1 = sol.longestSpanI(arr1, arr2);
		int res2 = sol.longestSpanII(arr1, arr2);
		System.out.println(res1[0]);
		System.out.println(res1[1]);
		System.out.println(res2);
	}
}
