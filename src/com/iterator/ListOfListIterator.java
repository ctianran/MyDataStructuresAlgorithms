package com.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 1/30/2017.
 */
public class ListOfListIterator {
	private List<List<Integer>> input;
	private int listIdx;
	private int eleIdx;

	public ListOfListIterator(List<List<Integer>> input) {
		if(input == null || input.size() == 0) {
			return;
		}
		this.input = input;
		this.listIdx = 0;
		this.eleIdx = 0;
	}

	public boolean hasNext() {
		if(listIdx < input.size() - 1) {
			return true;
		}
		if(listIdx == input.size() - 1 && eleIdx < input.get(input.size() - 1).size()) {
			return true;
		}
		return false;
	}

	public Integer next() {
		Integer cur = input.get(listIdx).get(eleIdx);
		if(eleIdx == input.get(listIdx).size() - 1) {
			listIdx++;
			eleIdx = 0;
		} else {
			eleIdx++;
		}
		return cur;
	}

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();

		l1.add(1);
		l1.add(2);
		l1.add(3);
		l2.add(4);
		l2.add(5);
		l3.add(6);
		l3.add(7);
		l3.add(8);

		input.add(l1);
		input.add(l2);
		input.add(l3);

		ListOfListIterator sol = new ListOfListIterator(input);
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());

	}
}
