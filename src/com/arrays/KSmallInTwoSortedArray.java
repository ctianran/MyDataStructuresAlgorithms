package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 7/4/2017.
 */
public class KSmallInTwoSortedArray {
	public List<Integer> kSamll(int[] nums1, int[] nums2, int k) {
			List<Integer> res = new ArrayList<>();
			int i = 0;
			int j = 0;
			while(k > 1) {
				int halfK = k / 2 - 1;
				int halfI = i + halfK;
				int halfJ = j + halfK;
				if (halfI < nums1.length && halfJ < nums2.length) {
					if(nums1[halfI] < nums2[halfJ]) {
						for(int m = i; m <= i + halfI; m++) {
							res.add(nums1[m]);
						}
						i = halfI + 1;
					} else {
						for(int m = j; m <= j + halfJ; m++) {
							res.add(nums2[m]);
						}
						j = halfJ + 1;
					}
				} else if(halfI < nums1.length) {
					for(int m = i; m <= i + halfI; m++) {
						res.add(nums1[m]);
					}
					i = halfI + 1;
				} else if(halfJ < nums2.length) {
					for(int m = j; m <= j + halfJ; m++) {
						res.add(nums2[m]);
					}
					j = halfJ + 1;
				}
				//increment
				k = k - k/2;
			}
			if(k == 1) {
				res.add(Math.min(nums1[i], nums2[j]));
			}
			return res;
		}

	public static void main(String[] args) {
		int[] A = new int[]{2, 5, 7, 10, 13};
		int[] B = new int[]{1, 3, 5, 13, 20, 29};

		KSmallInTwoSortedArray sol = new KSmallInTwoSortedArray();
		List<Integer> res = sol.kSamll(A, B, 7);
		System.out.println(res);
	}
}
