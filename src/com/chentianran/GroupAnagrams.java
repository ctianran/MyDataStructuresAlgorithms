package com.chentianran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 1/18/2017.
 */
public class GroupAnagrams {
	public List<List<String>> getAnagrams(String[] input) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(input == null || input.length == 0) {
			return result;
		}
		Map<String, List<String>> map = new HashMap<>();
		for(String s : input) {
			char[] array = new char[26];
			for(int i = 0; i < s.length(); i++) {
				array[s.charAt(i) - 'a']++;
			}

			String pattern = new String(array);

			if(map.containsKey(pattern)) {
				map.get(pattern).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(pattern, list);
			}
		}
		result.addAll(map.values());
		return result;
	}
}
