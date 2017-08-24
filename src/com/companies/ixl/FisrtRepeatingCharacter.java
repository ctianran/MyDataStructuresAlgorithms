package com.companies.ixl;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by Tianran on 8/13/2017.
 */
public class FisrtRepeatingCharacter {
	public char firstRepeat(String s) {
		if(s == null || s.length() == 0) {
			throw new NoSuchElementException("There is no repeating character.");
		}
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			if(!set.add(s.charAt(i))) {
				return s.charAt(i);
			}
		}
		throw new NoSuchElementException("There is no repeating character.");
	}
}
