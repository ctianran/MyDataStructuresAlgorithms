package com.chentianran;

/**
 * Created by Tianran on 1/16/2017.
 */
public class StringShiftToRightByN {
	public String shift(String input, int n) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		n = n % array.length;
		int left = 0;
		int right = array.length - 1;
		helper(array, left, right - n);
		helper(array, right - n + 1, right);
		helper(array, 0, right);
		return new String(array);
	}

	private void helper(char[] input, int left, int right) {
		while(left < right) {
			char temp = input[left];
			input[left] = input[right];
			input[right] = temp;
			left++;
			right--;
		}
	}
}
