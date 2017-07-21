package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/3/2017.
 */
public class FindAllSubsets {
	public List<String> subSet(String input) {
		List<String> result = new ArrayList<>();
		if(input == null) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helperDedupII(input, sb, 0, result);
		return result;
	}

	private void helper(String input, StringBuilder sb, int index, List<String> result) {
		if(index == input.length()) {
			result.add(sb.toString());
			return;
		}
		sb.append(input.charAt(index));
		helper(input, sb, index + 1, result);
		sb.deleteCharAt(sb.length() - 1);

		helper(input, sb, index + 1, result);
	}

	private void helperII(String input, StringBuilder sb, int index, List<String> result) {
		result.add(sb.toString());
		for(int i = index; i < input.length(); i++) {
			sb.append(input.charAt(i));
			helperII(input, sb, i + 1, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private void helperDedup(String input, StringBuilder sb, int index, List<String> result) {
		if(index == input.length()) {
			result.add(sb.toString());
			return;
		}
		sb.append(input.charAt(index));
		helperDedup(input, sb, index + 1, result);
		sb.deleteCharAt(sb.length() - 1);

		while(index + 1 < input.length() && input.charAt(index) == input.charAt(index + 1)) {
			index++;
		}
		helperDedup(input, sb, index + 1, result);
	}

	private void helperDedupII(String input, StringBuilder sb, int index, List<String> result) {
		result.add(sb.toString());

		for(int i = index; i < input.length(); i++) {
			sb.append(input.charAt(i));
			helperDedupII(input, sb, i + 1, result);
			while(i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
				i++;
			}
			sb.deleteCharAt(sb.length() - 1);
		}
	}


	public List<String> getAllRecur(String input) {
		List<String> res = helperRecu(input, input.length() - 1);
		return res;
	}

	private List<String> helperRecu(String input, int index) {
		if(index == -1) {
			List<String> res = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			res.add(sb.toString());
			return res;
		}

		List<String> subSol = helperRecu(input, index - 1);
		List<String> res = new ArrayList<>();

		for(String s : subSol) {
			//not add element
			res.add(s);
			//add new element
			StringBuilder temp = new StringBuilder(s);
			temp.append(input.charAt(index));
			res.add(temp.toString());
		}
		return res;
	}

	public static void main(String[] args) {
		String input = "abc";
		FindAllSubsets sol = new FindAllSubsets();
		List<String> res = sol.subSet(input);
		List<String> res1 = sol.getAllRecur(input);
		System.out.println(res);
		System.out.println(res1);
	}
}
