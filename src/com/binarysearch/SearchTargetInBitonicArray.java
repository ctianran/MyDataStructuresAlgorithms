package com.binarysearch;

/**
 * Created by Tianran on 2/7/2017.
 */
public class SearchTargetInBitonicArray {
	public int search(int[] array, int target) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		int max = findMax(array, left, right);
		int leftNum = searchAscending(array, left, max, target);
		if(leftNum == -1) {
			return searchDescending(array, max + 1, right, target);
		}
		return leftNum;
	}

	private int findMax(int[] array, int left, int right) {
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(array[mid] < array[mid + 1]) {
				left = mid + 1;
			} else if(array[mid] > array[mid + 1]) {
				right = mid;
			}
		}
		return left;
	}

	private int searchAscending(int[] array, int left, int right, int target) {
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	private int searchDescending(int[] array, int left, int right, int target){
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 3, 5, 8, 6, 4, 2};
		SearchTargetInBitonicArray sol = new SearchTargetInBitonicArray();
		int res = sol.search(input, 4);
		System.out.println(res);
	}
}
