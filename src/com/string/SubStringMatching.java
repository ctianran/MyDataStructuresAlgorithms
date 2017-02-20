package com.string;

/**
 * Created by Tianran on 2/19/2017.
 */
public class SubStringMatching {
	public int strStr(String large, String small) {
		if(small.length() > large.length()) {
			return -1;
		}
		if(small.isEmpty()) {
			return 0;
		}
		for(int i = 0; i <= large.length() - small.length(); i++) {
			if(isStr(large, small, i)) {
				return i;
			}
		}
		return -1;
	}

	private boolean isStr(String large, String small, int start) {
		for(int i = 0; i < small.length(); i++) {
			if(large.charAt(i + start) != small.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
