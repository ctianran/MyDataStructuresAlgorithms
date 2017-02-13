package com.string;

/**
 * Created by Tianran on 2/12/2017.
 */
public class ReverseString {
	public String reverse(String input) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		StringBuilder sb = new StringBuilder(input);
		int left = 0;
		int right = sb.length()- 1;
		while(left < right) {
			swap(sb, left++, right--);
		}
		return new String(sb);
	}

	private void swap(StringBuilder sb, int left, int right) {
		char temp = sb.charAt(left);
		sb.setCharAt(left,sb.charAt(right));
		sb.setCharAt(right, temp);
	}

	public static void main(String[] args) {
		String input = "abcde";
		ReverseString sol = new ReverseString();
		String res = sol.reverse(input);
		System.out.println(res);
	}
}
