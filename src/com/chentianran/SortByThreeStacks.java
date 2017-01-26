package com.chentianran;

import java.util.LinkedList;

/**
 * Created by Tianran on 1/26/2017.
 */
public class SortByThreeStacks {
	public void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		LinkedList<Integer> s3 = new LinkedList<Integer>();
		sort(s1, s2, s3, s1.size());
	}

	private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
		if(length <= 1) {
			return;
		}
		int mid1 = length / 2;
		int mid2 = length - mid1;
		for(int i = 0; i < mid1; i++) {
			s2.offerFirst(s1.pollFirst());
		}
		sort(s2, s3, s1, mid1);
		sort(s1, s3, s2, mid2);
		int i = 0;
		int j = 0;
		while(i < mid1 && j < mid2) {
			if(s2.peekFirst() < s1.peekFirst()) {
				s3.offerFirst(s2.pollFirst());
				i++;
			} else {
				s3.offerFirst(s1.pollFirst());
				j++;
			}
		}
		while(i < mid1) {
			s3.offerFirst(s2.pollFirst());
			i++;
		}
		while(j < mid2) {
			s3.offerFirst(s1.pollFirst());
			j++;
		}

		for(int k = 0; k < length; k++) {
			s1.offerFirst(s3.pollFirst());
		}
	}
}
