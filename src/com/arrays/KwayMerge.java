package com.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Tianran on 6/26/2017.
 */
public class KwayMerge {
	//Time: O(k^2 * n); // k: # of lists, n length of list
	public List<Integer> mergeI(List<List<Integer>> lists) {
		 List<Integer> res = new ArrayList<>();
		 res = lists.get(0);
		 for(int k = 1; k < lists.size(); k++) {
		 	  List<Integer> cur = lists.get(k);
		 	  List<Integer> temp = new ArrayList<>();
		 	  temp = mergeHelper(res, cur);
		    res = temp;
		 }
		 return res;
	}

	private List<Integer> mergeHelper(List<Integer> l1, List<Integer> l2) {
		List<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(i < l1.size() && j < l2.size()) {
			if(l1.get(i) == l2.get(j)) {
				res.add(l1.get(i++));
				res.add(l2.get(j++));
			} else if (l1.get(i) < l2.get(j)) {
				res.add(l1.get(i++));
			} else {
				res.add(l2.get(j++));
			}
		}
		while(i < l1.size()) {
			res.add(l1.get(i++));
		}
		while(j < l2.size()) {
			res.add(l2.get(j++));
		}
		return res;
	}

	//binary reduction
	//Time: O(kn*logk)
	public List<Integer> mergeII(List<List<Integer>> lists) {
				return null;
	}

	//minHeap
	//Time: O(k + knlogk)
	public List<Integer> mergeIII(List<List<Integer>> lists) {
		List<Integer> res = new ArrayList<>();
		if(lists == null || lists.size() == 0) {
			return res;
		}
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(lists.size(), new Comparator<Cell>(){
			@Override
			public int compare(Cell c1, Cell c2) {
				if(c1.val == c2.val) {
					return 0;
				}
				return c1.val < c2.val ? -1 : 1;
			}
		});
		for(int i = 0; i < lists.size(); i++) {
			if(lists.get(i).size() > 0) {
				minHeap.offer(new Cell(i, 0, lists.get(i).get(0)));
			}
		}
		while(!minHeap.isEmpty()) {
			Cell cur = minHeap.poll();
			res.add(cur.val);
			if(cur.idx + 1 < lists.get(cur.listIdx).size()) {
				cur.idx++;
				cur.val = lists.get(cur.listIdx).get(cur.idx);
				minHeap.offer(cur);
			}
		}
		return res;
	}

	class Cell {
		int listIdx;
		int idx;
		int val;
		public Cell(int listIdx, int idx, int val) {
			this.listIdx = listIdx;
			this.idx = idx;
			this.val = val;
		}
	}


	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(4);
		List<Integer> l2 = new ArrayList<>();
		l2.add(2);
		l2.add(5);
		List<Integer> l3 = new ArrayList<>();
		l3.add(3);
		l3.add(6);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);

		KwayMerge sol = new KwayMerge();
		List<Integer> res = sol.mergeIII(lists);
		System.out.println(res);
	}
}
