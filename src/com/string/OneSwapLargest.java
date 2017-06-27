package com.string;

/**
 * Created by Tianran on 6/17/2017.
 */
public class OneSwapLargest {
	public String oneSwap(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int len = array.length;
		int[] nextLargest = new int[len];
		nextLargest[len - 1] = -1;
		int curMaxIndex = len - 1;
		//scan the char array from right side to get the largest element's index on the right side
		for(int i = len - 2; i >= 0; i--) {
			if(array[i] < array[curMaxIndex]) {
				nextLargest[i] = curMaxIndex;
			} else {
				if(array[i] > array[curMaxIndex]) {
					curMaxIndex = i;
				}
				nextLargest[i] = -1;
			}
		}
		//scan from the left side to find the first element has next largest value and do swap
		for(int i = 0; i < len; i++) {
			if(nextLargest[i] != -1) {
				swap(array, i, nextLargest[i]);
				return new String(array);
			}
		}
		//if there is no next largest element, we check the duplicate elements, swap any pair will work
		for(int i = 0; i < len - 1; i++) {
			if(array[i] == array[i + 1]) {
				swap(array, i, i + 1);
				return new String(array);
			}
		}
		//if there is no duplicate elements, we can swap the last two elements
		swap(array, len - 1, len - 2);
		return new String(array);
	}

	private void swap(char[] array, int a, int b) {
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		String s = "1421";
		OneSwapLargest sol = new OneSwapLargest();
		String res = sol.oneSwap(s);
		System.out.println(res);
	}
}
