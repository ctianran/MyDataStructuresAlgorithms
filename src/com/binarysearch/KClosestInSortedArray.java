package com.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/8/2017.
 */
public class KClosestInSortedArray {
	public List<Integer> kClosest(int[] array, int target, int k) {
		List<Integer> result = new ArrayList<>();
		if(array == null || array.length == 0 || k == 0) {
			return result;
		}
		int left = getLargestSmallerEqual(array, target);
		int right = left + 1;

		for(int i = 0; i < k; i++) {
			if(right >= array.length || (left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target))) {
				result.add(array[left--]);
			} else {
				result.add(array[right++]);
			}
		}
		//return Arrays.asList(left + 1, right -1);
		return result;
	}

	private int getLargestSmallerEqual(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if(array[right] <= target) {
			return right;
		}
		if(array[left] <= target) {
			return left;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1,3,5,8,12,17,19};
		KClosestInSortedArray sol = new KClosestInSortedArray();
		List<Integer> res = sol.kClosest(input, 9, 4);
		System.out.println(res);
	}
}
