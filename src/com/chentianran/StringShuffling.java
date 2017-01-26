package com.chentianran;

/**
 * Created by Tianran on 1/16/2017.
 *
 * input: "ABCD1234"
 * output: "A1B2C3D4"
 */
public class StringShuffling {
	 public String shuffle(String input) {
	 	  if(input == null || input.length() <= 1) {
	 	  	return input;
	    }
	    char[] array = input.toCharArray();
	 	  if(array.length % 2 == 0) {
	 	  	helper(array, 0, array.length-1);
	    } else {
	 	  	helper(array, 0, array.length - 2);
	    }
	    return new String(array);
	 }

	 private void helper(char[] array, int left, int right) {
	 	  int length = right - left + 1;
	 	  if(length <= 2) {
		  	return;
	    }
	    int mid = left + length / 2;
	 	  int lmid = left + length / 4;
	 	  int rmid = left + length * 3/4;
	 	  reverse(array, lmid, rmid -1);
	 	  reverse(array, lmid, mid - 1);
	 	  reverse(array, mid, rmid - 1);

	 	  helper(array, left, left + (lmid - left) * 2 - 1);
	 	  helper(array, left + (lmid - left) * 2, right);
	 }

	 private void reverse(char[] array, int left, int right) {
	 	  while(left < right) {
	 	  	char temp = array[left];
	 	  	array[left] = array[right];
	 	  	array[right] = temp;
	 	  	left++;
	 	  	right--;
	    }
	 }
}
