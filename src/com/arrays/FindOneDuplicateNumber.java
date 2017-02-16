package com.arrays;

/**
 * Created by Tianran on 2/15/2017.
 */
public class FindOneDuplicateNumber {
	public int duplicate(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		for(int i = 0; i < array.length; i++) {
			while(array[i] != i + 1 && array[i] != array[array[i] - 1]) {
				swap(array, i, array[i] - 1);
			}
			if(array[i] != i + 1) {
				return array[i];
			}
		}
		return array[array.length - 1];
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] input = new int[] {3, 2, 1, 4,2};
		FindOneDuplicateNumber sol = new FindOneDuplicateNumber();
		int res = sol.duplicate(input);
		System.out.println(res);
	}
}
