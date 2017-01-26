package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 1/18/2017.
 */
public class FindAllAnagrams {
	public List<Integer> anagrams(String input, String pattern) {
		List<Integer> result = new ArrayList<>();
		if(pattern.length() > input.length()) {
			return result;
		}
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : pattern.toCharArray()) {
			Integer count = map.get(ch);
			if(count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
		}

		int charToMatch = map.size();
		int slow = 0;
		for(int fast = 0; fast < input.length(); fast++) {
			char chFast = input.charAt(fast);
			if(map.containsKey(chFast)) {
				Integer countFast = map.get(chFast);
				map.put(chFast, countFast - 1);
				if(countFast == 1) {
					charToMatch--;
				}
			}

			if(fast >= pattern.length()) {
				char chSlow = input.charAt(slow++);
				if(map.containsKey(chSlow)) {
					Integer countSlow = map.get(chSlow);
					map.put(chSlow, countSlow + 1);
					if(countSlow == 0) {
						charToMatch++;
					}
				}
			}

			if(charToMatch == 0) {
				result.add(slow);
			}
		}
		return result;
	}
}
