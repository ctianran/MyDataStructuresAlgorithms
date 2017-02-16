package com.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 2/14/2017.
 */
public class MissingNumberOneToN {
	public int missingI(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int n = array.length + 1;
		for(int i = 1; i <= n; i++) {
			int j = 0;
			for(; j < array.length; j++) {
				if(array[j] == i) {
					break;
				}
			}
			if(j == array.length) {
				return i;
			}
		}
		return 0;
	}

	public int missingII(int[] array) {
		int n = array.length  + 1;
		Set<Integer> set = new HashSet<>();
		for(int num : array) {
			set.add(num);
		}
		for(int i = 1; i < n; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		return n;
	}
	//sorted array
	public int missingIII(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int left = 0;
		int right= array.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] == mid + 1) {
				left = mid + 1;
			} else if (array[mid] == mid + 2) {
				right = mid;
			}
		}
		if(array[left] == left + 2) {
			return left + 1;
		}
		if(array[right] == right + 2) {
			return right + 1;
		}
		return right + 2;
	}

	public int missingIV(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		for(int i = 0; i < array.length; i++) {
			while(array[i] != i + 1 && array[i] != array.length + 1) {
				swap(array, i, array[i] - 1);
			}
		}
		for(int i = 0 ; i < array.length; i++) {
			if(array[i] != i + 1) {
				return i + 1;
			}
		}
		return array.length + 1;
	}

	public int missingV(int[] array) {
		int n = array.length + 1;
		int xor = 0;
		for(int num : array) {
			xor ^= 1;
		}
		for(int i = 1; i <= n; i++) {
			xor ^= i;
		}
		return xor;
	}

	public int missingVI(int[] array) {
		int n = array.length + 1;
		long targetSum = (n + 0L) * (n + 1) / 2;
		long actualSum = 0L;
		for(int num : array) {
			actualSum += num;
		}
		return (int) (targetSum - actualSum);
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1,3,4};
		MissingNumberOneToN sol = new MissingNumberOneToN();
		int res = sol.missingVI(input);
		System.out.println(res);
	}
}
