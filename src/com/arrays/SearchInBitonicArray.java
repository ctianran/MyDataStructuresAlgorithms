package com.arrays;

/**
 * Created by Tianran on 7/1/2017.
 */
public class SearchInBitonicArray {
	public int searchTarget(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int max = getMax(nums);
		int incIdx = searchInc(nums, 0, max, target);
		if(incIdx == -1) {
			return searchDec(nums, max + 1, nums.length - 1, target);
		}
		return incIdx;
	}

	private int getMax(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private int searchInc(int[] nums, int left, int right, int target) {
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	private int searchDec(int[] nums, int left, int right, int target) {
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 6, 7, 4, 2, 0};
		SearchInBitonicArray sol = new SearchInBitonicArray();
		int res = sol.searchTarget(nums, 2);
		System.out.println(res);
	}
}
