package com.arrays;

/**
 * Created by Tianran on 2/9/2017.
 */
public class QuickSelect {
	public int quickSelect(int[] array, int k) {
		if(array == null || array.length == 0 || k == 0 || k > array.length) {
			return -1;
		}
		return helper(array, 0, array.length - 1, k);
	}

	private int helper(int[] array, int left, int right, int k) {
		int pivot = partition(array, left, right);
		if(pivot == k - 1){
			return array[pivot];
		} else if (pivot < k - 1) {
			return helper(array, pivot + 1, right, k);
		} else {
			return helper(array, left, pivot -1, k);
		}
	}

	private int partition(int[] array, int left, int right) {
		int pivot = left + (int)(Math.random() * (right - left + 1));
		int pVal = array[pivot];
		swap(array, pivot, right);
		int lIdx = left;
		int rIdx = right - 1;
		while(lIdx <= rIdx) {
			if(array[lIdx] < pVal) {
				lIdx++;
			} else {
				swap(array, lIdx, rIdx--);
			}
		}
		swap(array, lIdx, right);
		return lIdx;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] input = new int[] {3, 1, 2, 5, 4};
		QuickSelect sol = new QuickSelect();
		int res = sol.quickSelect(input, 5);
		System.out.println(res);
	}
}
