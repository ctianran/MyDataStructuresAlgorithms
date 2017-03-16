package com.stdin;

import java.util.Scanner;

/**
 * Created by Tianran on 3/13/2017.
 */
public class InputTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		String[] input = new String[len];
		for(int i = 0; i < len; i++) {
			input[i] = scan.next();
		}

		for(int i = 0; i < len; i++) {
			System.out.println(input[i]);
		}
	}
}
