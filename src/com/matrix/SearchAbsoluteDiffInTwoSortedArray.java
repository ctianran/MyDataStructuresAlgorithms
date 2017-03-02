package com.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 3/1/2017.
 */
public class SearchAbsoluteDiffInTwoSortedArray {
	public List<List<Integer>> search(int[] arr1, int[] arr2, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
			return result;
		}
		int i = 0;
		int j = 0;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] - arr2[j] == target) {
				result.add(Arrays.asList(i, j));
				i++;
			} else if(arr1[i] - arr2[j] < target) {
				i++;
			} else {
				j++;
			}
		}

		i = 0;
		j = 0;
		while (i < arr1.length && j < arr2.length) {
			if(arr2[j] - arr1[i] == target) {
				result.add(Arrays.asList(i, j));
				j++;
			} else if (arr2[j] - arr1[i] < target) {
				j++;
			} else {
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[] {1, 2, 3};
		int[] arr2 = new int[] {2, 3, 5};
		SearchAbsoluteDiffInTwoSortedArray sol = new SearchAbsoluteDiffInTwoSortedArray();
		List<List<Integer>> res = sol.search(arr1, arr2, 4);
		System.out.println(res);
	}
}
