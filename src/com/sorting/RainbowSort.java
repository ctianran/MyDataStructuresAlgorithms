package com.sorting;

/**
 * Created by Tianran on 2/23/2017.
 */
public class RainbowSort {
	public int[] rainbowSort(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		int t = array.length - 1;
		while(k <= t) {
			if(array[k] == 1) {
				swap(array, i++, k);
			} else if(array[k] == 2) {
				swap(array, j++, k);
			} else if(array[k] == 3) {
				k++;
			} else if(array[k] == 4) {
				swap(array, k, t--);
			}
			if(i > j) {
				j++;
			}
			if(j > k) {
				k++;
			}
		}
		return array;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] input = new int[]{1,2,2,3,4,1,2,3,4,1,2};
		RainbowSort sol = new RainbowSort();
		int[] res = sol.rainbowSort(input);
		for(int num : res) {
			System.out.print(num + " ");
		}
	}
}
