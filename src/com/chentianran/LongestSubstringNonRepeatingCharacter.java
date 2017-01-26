package com.chentianran;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Tianran on 1/18/2017.
 */
public class LongestSubstringNonRepeatingCharacter {
	public int longestI(String input) {
		if(input == null || input.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<>();
		int result = 0;
		int slow = 0;
		int fast = 0;
		while (fast < input.length()) {
			if(set.contains(input.charAt(fast))) {
				set.remove(input.charAt(slow++));
			} else {
				set.add(input.charAt(fast++));
				result = Math.max(result, fast - slow);
			}
		}
		return result;
	}

	public String longestII(String input) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		Map<Character, Integer> map = new HashMap<>();
		int slow = 0;
		int result = 0;
		int start = 0;
		int end = 0;
		for(int fast = 0; fast < input.length(); fast++) {
			char ch = input.charAt(fast);
			Integer count = map.get(ch);
			if(count != null ) {
					map.put(ch, count + 1);
					if(count == 1) {
						while(map.get(ch) > 1) {
							Integer countSlow = map.get(input.charAt(slow));
							map.put(input.charAt(slow++), countSlow - 1);
						}
					}
			} else {
				map.put(ch, 1);
			}

			if(fast - slow > result) {
				result = fast - slow;
				start = slow;
				end = fast;
			}
		}
		return input.substring(start, end + 1);
	}

}
