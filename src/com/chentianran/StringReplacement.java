package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 1/16/2017.
 */
public class StringReplacement {
		public String replacement(String input, String target, String pattern) {
			if(input == null) {
				return input;
			}
			char[] array = input.toCharArray();
			if(target.length() >= pattern.length()) {
				return replaceShort(array, target, pattern);
			} else {
				return replaceLong(array, target, pattern);
			}
		}

		private String replaceShort(char[] array, String target, String pattern) {
			int slow = 0;
			for(int fast = 0; fast < array.length; fast++) {
				if(isSubString(array, target, fast)) {
					for(int i = 0; i < pattern.length(); i++) {
						array[slow++] = pattern.charAt(i);
					}
					fast += target.length();
				}
				array[slow++] = array[fast];
			}
			return new String(array, 0, slow);
		}

		private String replaceLong(char[] array, String target, String pattern) {
			List<Integer> indices = getIndices(array, target);
			if(indices.size() <= 0) {

				return new String(array);
			}
			char[] newArray = new char[array.length + indices.size() * (pattern.length() - target.length())];
			int fast = array.length - 1;
			int slow = newArray.length - 1;
			int index = indices.size() - 1;
			while(fast >= 0) {
				if(index >= 0 && fast == indices.get(index)) {
					for(int i = pattern.length() - 1; i >= 0; i--) {
						newArray[slow--] = pattern.charAt(i);
					}
					index--;
					fast -= target.length();
				}
				newArray[slow--] = array[fast--];
			}
			return new String(newArray);
		}

		private List<Integer> getIndices(char[] array, String target) {
			List<Integer> result = new ArrayList<Integer>();
			for(int i = 0; i <= array.length - target.length(); i++) {
				if(isSubString(array, target, i)) {
					result.add(i + target.length() - 1);
				}
			}
			return result;
		}
		private boolean isSubString(char[] array, String target, int start) {
			for(int i = 0; i < target.length(); i++) {
				if(array[i+start] != target.charAt(i)) {
					return false;
				}
			}
			return true;
		}

}
