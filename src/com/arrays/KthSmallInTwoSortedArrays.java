package com.arrays;

/**
 * Created by Tianran on 7/3/2017.
 */
public class KthSmallInTwoSortedArrays {
	public int kSmall(int[] A, int[] B, int k) {
		if(A == null || A.length == 0 || B == null || B.length == 0) {
			return -1;
		}
		int aLen = A.length;
		int bLen = B.length;
		if(k > A.length + B.length) {
			return -1;
		}
		int i = 0;
		int j = 0;
		while(i < aLen && j < bLen) {
			if(k == 1) {
				return A[i] <= B[j] ? A[i] : B[j];
			}
			if(A[i] <= B[j]) {
				i++;
			} else {
				j++;
			}
			k--;
		}
		return -1;
	}

	public int kSmallIter(int[] A, int[] B, int k) {
		int i = 0;
		int j = 0;
		while(k > 1) {
			int halfK = k / 2 - 1;
			int halfI = i + halfK;
			int halfJ = j + halfK;
			if (halfI < A.length && halfJ < B.length) {
				if(A[halfI] < B[halfJ]) {
					i = halfI + 1;
				} else {
					j = halfJ + 1;
				}
			} else if(halfI < A.length) {
				i = halfI + 1;
			} else if(halfJ < B.length) {
				j = halfJ + 1;
			}
			//increment
			k = k - k/2;
		}
		if(k == 1) {
			return Math.min(A[i], B[j]);
		}
		return -1;
	}



	public static void main(String[] args) {
		int[] A = new int[]{2, 5, 7, 10, 13};
		int[] B = new int[]{1, 3, 5, 13, 20, 29};

		KthSmallInTwoSortedArrays sol = new KthSmallInTwoSortedArrays();
		int res = sol.kSmall(A, B, 7);
		int res2 = sol.kSmallIter(A, B, 7);
		System.out.println(res);
		System.out.println(res2);
	}

}
