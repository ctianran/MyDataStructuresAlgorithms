package com.companies.ixl;

/**
 * Created by Tianran on 8/13/2017.
 */
public class MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int oddRes = getKth(nums1, nums2, 0, 0, (m + n + 1)/2);
		if((m + n) % 2 == 1) {
			return (double) oddRes;
		} else {
			int evenRes = getKth(nums1, nums2, 0, 0, (m + n + 2) / 2);
			return (oddRes + evenRes) / 2.0;
		}
	}

	private int getKth(int[] nums1, int[] nums2, int aleft, int bleft, int k) {
		if(aleft >= nums1.length) {
			return nums2[bleft + k - 1];
		}
		if(bleft >= nums2.length) {
			return nums1[aleft + k - 1];
		}
		if(k == 1) {
			return Math.min(nums1[aleft], nums2[bleft]);
		}
		int amid = aleft + k/2 - 1;
		int bmid = bleft + k/2 - 1;
		int aval = amid >= nums1.length ? Integer.MAX_VALUE : nums1[amid];
		int bval = bmid >= nums2.length ? Integer.MAX_VALUE : nums2[bmid];
		if(aval < bval) {
			return getKth(nums1, nums2, amid + 1, bleft, k - k/2);
		} else {
			return getKth(nums1, nums2, aleft, bmid + 1, k - k/2);
		}
	}
}
