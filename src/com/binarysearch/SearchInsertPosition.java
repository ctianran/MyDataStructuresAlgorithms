package com.binarysearch;

/**
 * Created by Tianran on 2/7/2017.
 *
 *
 *
 *
 */
public class SearchInsertPosition {
	public int insert(int[] array, int target) {
		if(array == null || array.length == 0) {
			return 0;
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
		if(array[left] >= target) {
			return left;
		}
		if(array[right] >= target) {
			return right;
		} else {
			return right + 1;
		}
	}
}
