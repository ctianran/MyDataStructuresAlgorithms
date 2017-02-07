package com.bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/5/2017.
 */
public class LargestStringLengthProduct {
	public int largest(String[] input) {
		Map<String, Integer> map = getBitMap(input);

		Arrays.sort(input, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return 0;
				}
				return s1.length() < s2.length() ? 1 : -1;
			}
		});

		int largest = 0;
		for(int i = 1; i < input.length; i++) {
			for(int j = 0; j < i; j++) {
				int product = input[i].length() * input[j].length();
				if(product <= largest) {
					break;
				}
				int iMask = map.get(input[i]);
				int jMask = map.get(input[j]);
				if((iMask & jMask) == 0) {
					largest = product;
				}
			}
		}
		return largest;
	}

	private Map<String, Integer> getBitMap(String[] input) {
		Map<String, Integer> bitMap = new HashMap<>();
		for(String s : input) {
			int bit = 0;
			for(int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				bit |= (1 << (ch - 'a'));
			}
			bitMap.put(s, bit);
		}
		return bitMap;
	}

	public static void main(String[] args) {
		String[] input = new String[] {"abcde", "fghi", "abd", "fgz"};
		LargestStringLengthProduct sol = new LargestStringLengthProduct();
		int res = sol.largest(input);
		System.out.println(res);
	}
}
