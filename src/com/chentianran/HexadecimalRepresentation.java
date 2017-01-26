package com.chentianran;

/**
 * Created by Tianran on 1/19/2017.
 */
public class HexadecimalRepresentation {
	public String convertI(int num) {
		String prefix = "0x";
		if(num == 0) {
			return prefix + "0";
		}
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			int rem = num & 15;
			if(rem < 10) {
				sb.append((char) ('0' + rem));
			} else {
				sb.append((char)(rem - 10 + 'A'));
			}
			num >>>= 4;
		}
		return prefix + sb.reverse().toString();
	}

	public String convertII(int num) {
		String prefix = "0x";
		char[] map = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B','C', 'D', 'E', 'F'};
		if(num == 0) {
			return prefix + "0";
		}
		StringBuilder sb = new StringBuilder();

		while(num > 0) {
			int rem = num % 16;
			num /= 16;
			sb.append(map[rem]);
		}

		return prefix + sb.reverse().toString();

	}
}
