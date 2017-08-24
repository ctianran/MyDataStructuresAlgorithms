package com.companies.ixl;

/**
 * Created by Tianran on 8/13/2017.
 */
public class RandomOddNumber {
	public int generate(int min, int max) {
		int randNum = min + (int)(Math.random() * (max - min + 1));
		//even number
		if(randNum % 2 == 0) {
			//handle boundary
			if(randNum == max) {
				return randNum - 1;
			}
			return randNum + 1;
		}
		return randNum;  //odd
	}

	public static void main(String[] args) {
		RandomOddNumber sol = new RandomOddNumber();

		int res = sol.generate(2, 101);
		System.out.println(res);
	}
}
