package com.binarysearch;

/**
 * Created by Tianran on 2/7/2017.
 */
public class SearchMinimumInRotatedSortedArray {
	public int searchNoDup(int[] array) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] > array[right]) {
				left = mid + 1;
 	  	} else if (array[mid] < array[right]) {
				right = mid;
			}
		}
		return array[left] < array[right] ? left : right;
	}

	public int searchDup(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] == array[right]) {
				right--;
			} else if(array[mid] > array[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return array[left] < array[right] ? left : right;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5};
		int[] array1 = new int[] {3, 4, 5, 1, 2};
		int[] array2 = new int[] {3,1,1,3};
		SearchMinimumInRotatedSortedArray sol = new SearchMinimumInRotatedSortedArray();
		int res = sol.searchNoDup(array1);
		int res2 = sol.searchDup(array2);
		System.out.println(res);
		System.out.println(res2);
	}

}
