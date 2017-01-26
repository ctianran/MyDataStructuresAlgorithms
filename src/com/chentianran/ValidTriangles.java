package com.chentianran;

import java.util.Arrays;

/**
 * Created by Tianran on 1/25/2017.
 */
public class ValidTriangles {
	public int validTriangles(int[] input) {
		if(input == null || input.length <= 2) {
			return 0;
		}
		Arrays.sort(input);
		int result = 0;
		for(int i = 0; i < input.length - 2; i++) {
			int left = i + 1;
			int right = input.length - 1;
			while(left < right) {
				if(input[i] + input[left] > input[right]) {
					result++;
				}
				left++;
			}
		}
		return result;
	}
}
