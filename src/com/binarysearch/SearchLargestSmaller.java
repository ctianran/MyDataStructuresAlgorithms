package com.binarysearch;

/**
 * Created by Tianran on 2/7/2017.
 */
public class SearchLargestSmaller {
	public int search(int[] array, int target) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		if(array[right] < target) {
			return right;
		}
		if(array[left] < target) {
			return left;
		}
		return -1;
	}
}
