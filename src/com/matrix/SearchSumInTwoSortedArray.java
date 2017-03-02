package com.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 3/1/2017.
 */
public class SearchSumInTwoSortedArray {
	public List<List<Integer>> search(int[] nums1, int[] nums2, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return result;
		}
		int i = nums1.length - 1;
		int j = 0;
		while(i >= 0 && j < nums2.length) {
			if(nums1[i] + nums2[j] == target) {
				result.add(Arrays.asList(i, j));
				i--;
			} else if (nums1[i] + nums2[j] < target) {
				j++;
			} else {
				i--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 3};
		int[] nums2 = new int[] {2, 3, 5};
		SearchSumInTwoSortedArray sol = new SearchSumInTwoSortedArray();
		List<List<Integer>> res = sol.search(nums1, nums2, 4);
		System.out.println(res);
	}
}
