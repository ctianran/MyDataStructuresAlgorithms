package com.chentianran;

import java.util.Arrays;

/**
 * Created by Tianran on 1/17/2017.
 */
public class StringDecoding {
		public String decode(String input) {
			if(input.length() <= 1) {
				return input;
			}
			char[] array = input.toCharArray();
			int[] count = new int[1];
			array = decodeShort(array, count);
			return decodeLong(array, count);
		}

		private char[] decodeShort(char[] array, int[] count) {
			int slow = 0;
			for(int i = 0; i < array.length; i++) {
				if (array[i] >= '0' && array[i] <= '9' && (i == 0 || array[i - 1] >= 'A')) {
					array[slow++] = array[i-1];
					int start = i;
					int num = (int) array[i] - '0';
					while (start + 1 < array.length && array[start + 1] >= '0' && array[start + 1] <= '9') {
						start++;
						num = num * 10 + (int) array[start] - '0';
					}
					if (num == 1) {
						i++;
					} else if (num == 2) {
						array[slow++] = array[i - 1];
					} else if (num > 2) {
						int length = start - i + 1;
						count[0] += num - length - 1;
						for (int j = 0; j < length; j++) {
							array[slow++] = array[i++];
						}
					}
				}
			}
			return Arrays.copyOf(array, slow);
		}

		private String decodeLong(char[] array, int[] count) {
			if(count[0] == 0) {
				return new String(array);
			}
			char[] result = new char[array.length + count[0]];
			int slow = result.length - 1;
			int fast = array.length - 1;
			while(fast >= 0) {
			  if(array[fast] >= 'A' && (fast == array.length - 1 || array[fast + 1] >= '0' && array[fast + 1] <= '9')) {
					int num = readDigit(array, fast + 1);
					for(int i = 0; i < num; i++) {
						result[slow--] = array[fast];
					}
					fast--;
				}
				result[slow--] = array[fast--];

			}
			return new String(result);
		}

		private int readDigit(char[] array, int start) {
			int num = 0;
			while(start < array.length && array[start] >= '0' && array[start] <= '9') {
				num = num * 10 + (int) array[start] - '0';
				start++;
			}
			return num;
		}
}
