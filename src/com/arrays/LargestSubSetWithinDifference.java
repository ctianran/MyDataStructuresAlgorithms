package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LargestSubSetWithinDifference {
	public List<Integer> largestSubset(int[] array, int diff) {
		List<Integer> result = new ArrayList<>();
		if(array == null || array.length == 0) {
			return result;
		}
		Arrays.sort(array);
		int length = 0;
		int start = 0;
		int slow = 0;
		int fast = 0;
		while(fast < array.length) {
			if(array[fast] - array[slow] <= diff) {
				fast++;
			} else {
				slow++;
			}
			if(fast - slow > length) {
				length = fast - slow;
				start = slow;
			}
		}
		for(int i = start; i < length; i++) {
			result.add(array[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {4, 3, 0, 15, 21};
		LargestSubSetWithinDifference sol = new LargestSubSetWithinDifference();
		List<Integer> res = sol.largestSubset(nums, 3);
		System.out.println(res);
	}
}
