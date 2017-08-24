package com.companies.ixl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 8/13/2017.
 */
public class FindTheDerangement {
	public List<String> allPerm(String s) {
		List<String> res = new ArrayList<>();
		if(s == null) {
			return res;
		}
		char[] array = s.toCharArray();
		char[] old = array.clone();
		helper(array, 0, res, old);
		return res;
	}

	private void helper(char[] array, int index, List<String> res, char[] old) {
		if(index == array.length) {
			res.add(new String(array));
			return;
		}

		for(int i = index; i < array.length; i++) {
				if(array[i] != old[index]) {
					swap(array, index, i);
					helper(array, index + 1, res, old);
					swap(array, index, i);
				}
		}
	}

	private void swap(char[] array, int a, int b) {
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public List<String> allPermII(String s) {
		List<String> res = new ArrayList<>();
		if(s == null) {
			return res;
		}
		StringBuilder sb = new StringBuilder();
		boolean[] used = new boolean[s.length()];
		helperII(s, sb, 0, used, res);
		return res;
	}

	private void helperII(String s, StringBuilder sb, int index, boolean[] used, List<String> res) {
		if (index == s.length()) {
			res.add(sb.toString());
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if(i != index && !used[i]) {
				sb.append(s.charAt(i));
				used[i] = true;
				helperII(s, sb, index + 1, used, res);
				used[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		String s2 = "abbc";
		FindTheDerangement sol = new FindTheDerangement();
		List<String> res = sol.allPerm(s);
		System.out.println(res);
		List<String> res2 = sol.allPermII(s2);
		System.out.println(res2);
	}
}
