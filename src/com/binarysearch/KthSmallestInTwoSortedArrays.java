package com.binarysearch;

/**
 * Created by Tianran on 2/8/2017.
 */
public class KthSmallestInTwoSortedArrays {
	public int kthSmallest(int[] a, int[] b, int k) {
		if(a.length + b.length < k) {
			throw new IllegalArgumentException("Invalid input");
		}
		return helper(a, b, 0, 0, k);
	}

	private int helper(int[] a, int[] b, int aIndex, int bIndex, int k) {
		if(aIndex >= a.length) {
			return b[bIndex + k - 1];
		}
		if(bIndex >= b.length) {
			return a[aIndex + k - 1];
		}
		if(k == 1) {
			return Math.min(a[aIndex], b[bIndex]);
		}
		int amid = aIndex + k / 2 - 1;
		int bmid = bIndex + k / 2 - 1;
		int aval = amid < a.length ? a[amid] : Integer.MAX_VALUE;
		int bval = bmid < b.length ? b[bmid] : Integer.MAX_VALUE;
		if(aval <= bval) {
			return helper(a, b, amid + 1, bIndex, k - k / 2);
		} else {
			return helper(a, b, aIndex, bmid + 1, k - k / 2);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] {2, 5, 7, 10, 13};
		int[] b = new int[] {1, 3, 4, 13, 20, 29};
		KthSmallestInTwoSortedArrays sol = new KthSmallestInTwoSortedArrays();
		int res = sol.kthSmallest(a, b, 10);
		System.out.println(res);
	}

}
