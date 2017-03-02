package com.chentianran;

/**
 * Created by Tianran on 1/8/2017.
 */
public class ReplacementAandB {
	public int minReplace(String input) {
		int left = 0;
		int right = input.length() - 1;
		int result = 0;
		while (left <= right) {
			if(input.charAt(left) == 'a') {
				left++;
			} else if (input.charAt(right) == 'b') {
				right--;
			} else {
				int numL = countLeft(input, left);
				int numR = countRight(input, right);
				if(numL <= numR) {
					result += numL;
					left += numL;
				} else {
					result += numR;
					right -= numR;
				}
			}
		}
		return result;

	}

	private int countLeft(String input, int startIndex) {
		int count = 0;
		while(startIndex < input.length() && input.charAt(startIndex) == 'b') {
			count++;
			startIndex++;
		}
		return count;
	}

	private int countRight(String input, int startIndex) {
		int count = 0;
		while(startIndex >= 0 && input.charAt(startIndex) == 'a') {
			count++;
			startIndex--;
		}
		return count;
	}

	public static void main(String[] args) {

	}
}
