package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/3/2017.
 */
public class ParenthesisPermutation {
	public List<String> permuteI(int n) {
		List<String> result = new ArrayList<>();
		if(n == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helperI(n, 0, 0, sb, result);
		return result;
	}

	private void helperI(int n, int left, int right, StringBuilder sb, List<String> result) {
		if(sb.length() == n * 2) {
			result.add(sb.toString());
			return;
		}
		if(left < n) {
			sb.append("(");
			helperI(n, left + 1, right, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
		if(right < left) {
			sb.append(")");
			helperI(n, left, right + 1, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}

	}


	public List<String> permuteII(int n) {
		List<String> result = new ArrayList<>();
		if(n == 0) {
			return result;
		}
		char[] cur = new char[n * 2];
		helperII(cur, 0, n, n, result);
		return result;
	}

	private void helperII(char[] cur, int index, int left, int right, List<String> result) {
		if(left == 0 && right == 0) {
			result.add(new String(cur));
			return;
		}
		if(left > 0) {
			cur[index] = '(';
			helperII(cur, index + 1, left - 1, right, result);
		}
		if(right > left) {
			cur[index] = ')';
			helperII(cur, index + 1, left, right - 1, result);
		}
	}


	public static void main(String[] args) {
		ParenthesisPermutation sol = new ParenthesisPermutation();
		List<String> res = sol.permuteII(3);
		System.out.println(res);
	}
}
