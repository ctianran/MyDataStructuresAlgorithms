package com.arrays;

/**
 * Created by Tianran on 2/15/2017.
 */
public class FirstMissingPositiveNumber {
	public int missing(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		for(int i = 0; i < array.length; i++) {
			while(array[i] != i + 1 && array[i] <= array.length && array[i] > 0 && array[i] != array[array[i] - 1]) {
				swap(array, i, array[i] - 1);
			}
		}
		for(int i = 0; i < array.length; i++) {
			if(array[i] != i + 1) {
				return i + 1;
			}
		}
		return array.length + 1;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}


	public static void main(String[] args) {
		int[] input = new int[] {-1, 0, 2, 3};
		FirstMissingPositiveNumber sol = new FirstMissingPositiveNumber();
		int res = sol.missing(input);
		System.out.println(res);
	}
}
