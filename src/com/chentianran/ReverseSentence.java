package com.chentianran;

/**
 * Created by Tianran on 1/16/2017.
 */
public class ReverseSentence {
	public String reverse(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int i = 0;
		int start = 0;
		while (i < array.length) {
			if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
				start = i;
			}
			if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
				helper(array, start, i);
			}
			i++;
		}
		helper(array, 0, array.length - 1);
		return new String(array);
	}

	private void helper(char[] input, int left, int right) {
		while (left < right) {
			char temp = input[left];
			input[left] = input[right];
			input[right] = temp;
			left++;
			right--;
		}
	}
}
