package com.binarysearch;

/**
 * Created by Tianran on 2/8/2017.
 */
public class SearchInRotatedSortedArray {
	public int search(int[] array, int target) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				return mid;
				//skip duplicates
			} else if(array[mid] == array[left]) {
				left++;
			} else if(array[mid] == array[right]) {
				right--;
				//left half is in ascending
			} else if (array[mid] >= array[left]) {
				if(array[left] <= target && target < array[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
				//right half is in ascending
			} else {
				if(array[mid] < target && target <= array[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] input = new int[] {3, 3, 3, 1, 2};
		SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
		int res = sol.search(input, 1);
		System.out.println(res);
	}
}
