package com.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tianran on 2/2/2017.
 */
public class CyclicIteratorII {
	List<List<Integer>> input;
	Set<Integer> set;
	private int listIdx;
	private int curIdx;
	private int size;
	private int cap;

	public CyclicIteratorII(List<List<Integer>> input) {
		if(input == null || input.size() == 0) {
			return;
		}
		set = new HashSet<Integer>();
		this.input = input;
		this.listIdx = 0;
		this.curIdx = 0;
		this.size = 0;
		for(int i = 0; i < input.size(); i++) {
			List<Integer> temp = input.get(i);
			cap += temp.size();
		}

	}

	public boolean hasNext() {
		return size < cap;
	}

	public Integer next() {
		while(hasNext()) {
			while(curIdx >= input.get(listIdx).size()) {
				listIdx++;
				if(listIdx == input.size()) {
					listIdx = 0;
					curIdx++;
				}
			}

			int cur = input.get(listIdx).get(curIdx);
			size++;
			listIdx++;
			if(listIdx == input.size()) {
				listIdx = 0;
				curIdx++;
			}

			if(!set.contains(cur)) {
				set.add(cur);
				return cur;
			}

		}
		return null;
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

		CyclicIteratorII sol = new CyclicIteratorII(input);
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.hasNext());
		System.out.println(sol.next());
		System.out.println(sol.hasNext());


	}
}
