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
	//brute force
	//O(n^2)
	public int minReplaceII(String input) {
		int result = Integer.MAX_VALUE;
		for(int i = -1; i <= input.length(); i++) {
			int count = 0;
			for(int j = 0; j < input.length(); j++) {
				if(j > i && input.charAt(j) == 'a' || j <= i && input.charAt(j) == 'b') {
					count++;
				}
			}
			result = Math.min(result, count);
		}
		return result;
	}

	//Time: O(n)
	//Space: O(1)
	public int minReplaceIII(String input) {
		int result = Integer.MAX_VALUE;
		int numA = countChar(input, 'a');
		int numB = 0;
		for(int i = -1; i <= input.length(); i++) {
			if(i >= 0 && i < input.length()) {
				if (input.charAt(i) == 'a') {
					numA--;
				} else {
					numB++;
				}
			}
			result = Math.min(result, numB + numA);
		}
		return result;
	}

	private int countChar(String input, char ch) {
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
			String input = "b";
			ReplacementAandB sol = new ReplacementAandB();
			int res = sol.minReplace(input);
			int res2 = sol.minReplaceII(input);
			int res3 = sol.minReplaceIII(input);
		  System.out.println(res);
			System.out.println(res2);
			System.out.println(res3);
	}
}
