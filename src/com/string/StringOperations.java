package com.string;

import java.util.*;

/**
 * Created by Tianran on 3/7/2017.
 */
public class StringOperations {
	public String RandomGenerate(int length) {
		if(length == 0) {
			return new String();
		}
		String pattern = "abcdefghijklmnopqrstuvwxyz       ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < length; i++) {
			int num = random.nextInt(33);
			sb.append(pattern.charAt(num));
		}
		return sb.toString();
	}

	public List<String> splitDedup(String str) {
		List<String> result = new ArrayList<>();
		if(str == null || str.length() == 0) {
			return result;
		}
		int start = 0;
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch != ' ' && (i == 0 || str.charAt(i-1) == ' ')) {
				start = i;
				set.clear();
			}
			set.add(ch);
			if(ch != ' ' && (i == str.length() - 1) || str.charAt(i + 1) == ' ') {
				if(set.size() == i - start + 1) {
					result.add(str.substring(start, i + 1));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		StringOperations sol = new StringOperations();
		String input = sol.RandomGenerate(10);
		System.out.println(input);
		List<String> res = sol.splitDedup(input);
		System.out.println(res);

	}
}
