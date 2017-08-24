package com.thetradedesk;

/**
 * Created by Tianran on 8/3/2017.
 */
public class MergeStrings {
	public String merge(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		int[] mask = new int[26];
		for(int i = 0; i < strs.length; i++) {
			String s = strs[i];
			for(int j = 0; j < s.length(); j++) {
				mask[s.charAt(j) - 'a']++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < mask[i]; j++) {
				sb.append((char)(i + 'a'));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] strs = new String[] {"abc", "", "adc"};
		MergeStrings sol = new MergeStrings();
		String res = sol.merge(strs);
		System.out.println(res);
	}
}
