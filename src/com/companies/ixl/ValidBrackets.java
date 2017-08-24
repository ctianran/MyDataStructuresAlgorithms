package com.companies.ixl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 8/13/2017.
 */
public class ValidBrackets {
	public boolean isValid(String s) {
		if(s == null || s.length() <= 1) {
			return false;
		}
		//create the brackets mappings
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Deque<Character> stack = new ArrayDeque<>();

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			//find a left bracket
			if(map.containsKey(ch)) {
				stack.offerFirst(ch);
			} else { //find a right bracket, 1. check if stack is empty, 2. check if matching
				if(stack.isEmpty() || map.get(stack.peekFirst()) != ch) {
					return false;
				}
				stack.pollFirst();
			}
		}
		return stack.isEmpty();
	}
}
