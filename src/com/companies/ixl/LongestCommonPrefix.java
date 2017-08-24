package com.companies.ixl;

import java.util.Arrays;

/**
 * Created by Tianran on 8/14/2017.
 */
public class LongestCommonPrefix {
	//sorting the input strings
	//Time: O(nlogn * m)
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs);
		for(int i = 0; i < strs[0].length(); i++) {
			if(strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
				return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

	//no sorting the input strings, vertical scan
	//Time:O(m * n)
	public String longestCommonPrefixII(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		for(int i = 0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(i == strs[j].length()) {
					return strs[j];
				}
				if(strs[j].charAt(i) != ch) {
					return strs[i].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}
