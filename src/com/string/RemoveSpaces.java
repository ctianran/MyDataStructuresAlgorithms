package com.string;

/**
 * Created by Tianran on 2/19/2017.
 */
public class RemoveSpaces {
	public String removeSpaces(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		for(int fast = 0; fast < array.length; fast++) {
			if(array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
				continue;
			}
			array[slow++] = array[fast];
		}
		if(slow > 0 && array[slow - 1] == ' ') {
			return new String(array, 0, slow - 1);
		}
		return new String(array, 0, slow);
	}
}
