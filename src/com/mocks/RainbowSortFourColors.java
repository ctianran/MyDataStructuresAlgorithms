package com.mocks;

/**
 * Created by Tianran on 1/27/2017.
 */
public class RainbowSortFourColors {
	public char[] sort(char[] input) {
		if(input == null || input.length == 0) {
			return input;
		}

		int i = 0;
		int j = 0;
		int m = 0;
		int n = input.length - 1;

		while(m <= n) {
			if(input[m] == 'a') {
				swap(input, i++, m);
			} else if (input[m] == 'b') {
				swap(input, j++, m);
			} else if (input[m] == 'd') {
				swap(input, n--, m);
			} else {
				m++;
			}
			if(j < i) {
				j = i;
			}
			if(m < j) {
				m++;
			}
		}

		return input;
	}

	private void swap(char[] array, int a, int b) {
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		char[] arr = new char[] {'a', 'b', 'c','d','a', 'b', 'c','d','a', 'b', 'c','d'};

		RainbowSortFourColors sol = new RainbowSortFourColors();
		char[] res = sol.sort(arr);
		for(char ch : res) {
			System.out.print(ch + " ");
		}

	}
}

