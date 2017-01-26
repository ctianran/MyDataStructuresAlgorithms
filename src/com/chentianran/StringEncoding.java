package com.chentianran;

import java.util.Arrays;

/**
 * Created by Tianran on 1/17/2017.
 */
public class StringEncoding {
	public String encode(String input) {
		if(input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int[] countOne = new int[1];
		array = encodeLong(array, countOne);
		return encodeShort(array, countOne);
	}

	private char[] encodeLong(char[] array, int[] countOne) {
		int slow = 0;
		int fast = 0;
		for(fast = 0; fast < array.length - 1; fast++) {
			if(array[fast] == array[fast + 1]) {
				int start = fast;
				while(fast < array.length - 1 && array[fast] == array[fast + 1]) {
					fast++;
				}
				array[slow++] = array[fast];
				int count = fast - start + 1;
				String digits = "" + count;
				for(int i = 0; i < digits.length(); i++) {
					array[slow++] = digits.charAt(i);
				}
			} else {
				array[slow++] = array[fast];
				countOne[0]++;
			}
		}

		if(fast == array.length - 1) {
			array[slow++] = array[fast];
			countOne[0]++;
		}

		return Arrays.copyOf(array, slow);
	}

	private String encodeShort(char[] array, int[] countOne) {
		if(countOne[0] == 0) {
			return new String(array);
		}
		char[] newArray = new char[array.length + countOne[0]];
		int slow = newArray.length - 1;
		int fast = array.length - 1;
		while(fast >= 0) {
			if(array[fast] >= 'A' && (fast == array.length - 1 || array[fast + 1] >= 'A')) {
				newArray[slow--] = '1';
				newArray[slow--] = array[fast--];
			} else {
				newArray[slow--] = array[fast--];
			}
		}
		return new String(newArray);
	}
}
