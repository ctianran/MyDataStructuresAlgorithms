package com.binarysearch;

/**
 * Created by Tianran on 2/7/2017.
 */
public class SearchLocalMaximum {
	public int localMax(int[] array) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
				return mid;
			} else if (array[mid] < array[mid - 1]) {
				right = mid - 1;
			} else if (array[mid] < array[mid + 1]) {
				left = mid + 1;
			}
		}

		return array[left] > array[right] ? left : right;
	}
}
