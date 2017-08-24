package com.companies.ixl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 8/2/2017.
 */
public class MakeAnagrams {
	//Time: O(n)
	//Space: O(n)
	public int makeAnagrams(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return -1;
		}
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : s1.toCharArray()) {
			Integer count = map.get(ch);
			if(count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
		}
		int res = 0;
		for(char ch : s2.toCharArray()) {
			Integer count = map.get(ch);
			if(count == null) {
				res++;
			} else {
				if(count == 1) {
					map.remove(ch);
				} else {
					map.put(ch, count - 1);
				}
			}
		}
		return res;
	}

	//Time: O(n)
	//Space: O(26)  -> O(1)
	public int makeAnagramsII(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() != s2.length()) {
			return -1;
		}
		int[] mask = new int[26];
		for(int i = 0; i < s1.length(); i++) {
			mask[s1.charAt(i) - 'a']++;
			mask[s2.charAt(i) - 'a']--;
		}
		int res = 0;
		for(int i = 0; i < 26; i++) {
			res += Math.max(mask[i], 0);
		}
		return res;
	}
	public static void main(String[] args) {
		MakeAnagrams sol = new MakeAnagrams();
		int res = sol.makeAnagrams("aaa", "bbb");
		System.out.println(res);
		int resII = sol.makeAnagramsII("aaa", "bbb");
		System.out.println(resII);
	}
}
