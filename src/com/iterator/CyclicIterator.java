package com.iterator;

import java.util.*;

/**
 * Created by Tianran on 1/30/2017.
 */
public class CyclicIterator {
	Queue<Iterator> queue;
	Set<Integer> set;
	List<List<Integer>> input;
	public CyclicIterator(List<List<Integer>> input) {
		if(input == null || input.size() == 0) {
			return;
		}
		this.input = input;
		this.queue = new LinkedList<Iterator>();
		this.set = new HashSet<Integer>();
		for(List<Integer> l : input) {
			if(l.size() > 0) {
				Iterator<Integer> iter = l.iterator();
				queue.offer(iter);
			}
		}
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public Integer next() {
		while(!queue.isEmpty()) {
			Iterator<Integer> cur = queue.poll();
			Integer curVal = cur.next();
			if(!set.contains(curVal)) {
				set.add(curVal);
				if(cur.hasNext()) {
					queue.offer(cur);
				}
				return curVal;
			}
			if(cur.hasNext()) {
				queue.offer(cur);
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

		CyclicIterator sol = new CyclicIterator(input);
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
