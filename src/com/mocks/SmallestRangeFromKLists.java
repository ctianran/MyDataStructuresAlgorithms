package com.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Tianran on 1/27/2017.
 */
public class SmallestRangeFromKLists {
		public int smallestRange(List<List<Integer>> input) {
			if(input == null || input.size() <= 1) {
				return 0;
			}
			PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>();
			int minVal = Integer.MAX_VALUE;
			int maxVal = Integer.MIN_VALUE;
			int result = Integer.MAX_VALUE;
			int rows = input.size();

			for(int i = 0; i < rows; i++) {
				int num = input.get(i).get(0);
				maxVal = Math.max(maxVal, num);
				minHeap.offer(new Cell(i, 0, num));
			}

			while(minHeap.size() == input.size()) {
				Cell cur = minHeap.poll();
				result = Math.min(result, maxVal - cur.val);
				if(cur.col + 1 < input.get(cur.row).size()) {
					cur.col = cur.col + 1;
					cur.val = input.get(cur.row).get(cur.col);
					minHeap.offer(cur);
					maxVal = Math.max(maxVal, cur.val);
				}
			}
			return result;
		}

		class Cell implements Comparable<Cell> {
			int row;
			int col;
			int val;
			public Cell(int row, int col, int val) {
				this.row = row;
				this.col = col;
				this.val = val;
			}

			@Override
			public int compareTo(Cell another) {
				if(this.val == another.val) {
					return 0;
				}
				return this.val < another.val ? -1 : 1;
			}
		}

		public static void main(String[] args) {
			List<List<Integer>> lists = new ArrayList<List<Integer>>();
			List<Integer> l1 = new ArrayList<>();
			l1.add(4);
			l1.add(10);
			l1.add(15);
			l1.add(24);
			l1.add(26);

			List<Integer> l2 = new ArrayList<>();
			l2.add(0);
			l2.add(9);
			l2.add(12);
			l2.add(20);

			List<Integer> l3 = new ArrayList<>();
			l3.add(5);
			l3.add(18);
			l3.add(22);
			l3.add(30);

			lists.add(l1);
			lists.add(l2);
			lists.add(l3);

			SmallestRangeFromKLists sol = new SmallestRangeFromKLists();
			int res = sol.smallestRange(lists);
			System.out.println(res);
		}
}
