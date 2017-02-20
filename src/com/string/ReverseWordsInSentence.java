package com.string;

/**
 * Created by Tianran on 2/19/2017.
 */
public class ReverseWordsInSentence {
	public String reverseWords(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int start = 0;
		int slow = 0;
		for(int fast = 0; fast < array.length; fast++) {
			if(array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
				continue;
			}
			array[slow] = array[fast];
			if(array[slow] != ' ' && (slow == 0) || array[slow - 1] == ' ') {
				start = slow;
			}
			if(array[slow] == ' ') {
				reverse(array, start, slow - 1);
			} else if(fast == array.length - 1) {
				reverse(array, start, slow);
			}
			slow++;
		}

		if(slow > 0 && array[slow - 1] == ' ') {
			slow--;
		}
		reverse(array, 0, slow - 1);
		return new String(array,0, slow);
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

	public static void main(String[] args) {
		String input = "  I  love  Google ";
		ReverseWordsInSentence sol = new ReverseWordsInSentence();
		String res = sol.reverseWords(input);
		System.out.println(res);
	}
}
