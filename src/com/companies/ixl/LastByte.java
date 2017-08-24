package com.companies.ixl;

/**
 * Created by Tianran on 8/13/2017.
 */
public class LastByte {
	public int lastByte(char[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		if(array.length == 1) {
			return 1;
		}
		int i = 0;
		while(i < array.length - 1) {
			if(array[i] > 127) {
				i += 2;
			} else {
				i++;
			}
		}
		if(i == array.length) {
			return 2;
		}
		return 1;
	}
	public static void main(String[] args) {
		char[] array = new char[] {127, 128};
		char[] array2 = new char[] {128, 127};

		LastByte sol = new LastByte();
		int res = sol.lastByte(array);
		int res2 = sol.lastByte(array2);

		System.out.println(res);
		System.out.println(res2);
	}
}
