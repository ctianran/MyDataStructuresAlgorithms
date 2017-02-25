package com.arrays;

/**
 * Created by Tianran on 2/23/2017.
 */
public class MergeTwoSortedArray {
	public int[] merge(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0) {
			return nums2;
		}
		if(nums2 == null || nums2.length == 0) {
			return nums1;
		}
		int i = 0;
		int j = 0;
		int[] res = new int[nums1.length + nums2.length];
		while(i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				res[i + j] = nums1[i++];
			} else {
				res[i + j] = nums2[j++];
			}
		}
		while(i < nums1.length) {
			res[i + j] = nums1[i++];
		}
		while(j < nums2.length) {
			res[i + j] = nums2[j++];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 3, 5, 7, 9};
		int[] nums2 = new int[] {2, 6, 8, 10, 14};
		MergeTwoSortedArray sol = new MergeTwoSortedArray();
		int[] res = sol.merge(nums1, nums2);
		for(int num : res) {
			System.out.print(num + " ");
		}
	}
}
