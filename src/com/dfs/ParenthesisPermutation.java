package com.dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

	private static final char[] PS = new char[] {'(', ')', '[', ']', '{', '}'};

	public List<String> permuteIII(int l, int m, int n) {
			List<String> result = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			int[] remain = new int[] {l, l, m, m, n, n};
			Deque<Character> stack = new LinkedList<>();
			int length = l * 2 + m * 2 + n * 2;
			helperIII(sb, stack, remain, length, result);
			return result;
	}

	private void helperIII(StringBuilder sb, Deque<Character> stack, int[] remain, int length, List<String> result) {
		if(length == sb.length()) {
			result.add(sb.toString());
			return;
		}
		for(int i = 0; i < remain.length; i++) {
			if(i % 2 == 0) {
				if(remain[i] > 0) {
					sb.append(PS[i]);
					stack.offerFirst(PS[i]);
					remain[i]--;
					helperIII(sb, stack, remain, length, result);
					sb.deleteCharAt(sb.length() - 1);
					stack.pollFirst();
					remain[i]++;
				}
			} else {
				if(!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
					sb.append(PS[i]);
					stack.pollFirst();
					remain[i]--;
					helperIII(sb, stack, remain, length, result);
					sb.deleteCharAt(sb.length() - 1);
					stack.offerFirst(PS[i-1]);
					remain[i]++;
				}
			}
		}
	}


	public static void main(String[] args) {
		ParenthesisPermutation sol = new ParenthesisPermutation();
		List<String> res = sol.permuteIII(2,2,2);
		System.out.println(res);
	}
}
