package com.arrays;

import java.util.ArrayList;
import java.util.List;

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
		 	  int i = 0;
		 	  int j = 0;
		 	  while(i < res.size() || j < cur.size()) {
		 	  	if(i < res.size() && j < cur.size()) {
		 	  		if(res.get(i) == cur.get(j)) {
		 	  			temp.add(res.get(i++));
		 	  			temp.add(cur.get(j++));
				    } else if (res.get(i) < cur.get(j)) {
		 	  			temp.add(res.get(i++));
				    } else {
		 	  			temp.add(cur.get(j++));
				    }
			    } else if (i < res.size()) {
		 	  		temp.add(res.get(i++));
			    } else if(j < cur.size()) {
		 	  		temp.add(cur.get(j++));
			    }
		    }
		    res = temp;
		 }
		 return res;
	}

	public List<Integer> mergeII(List<List<Integer>> lists) {

	}



	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		List<Integer> l2 = new ArrayList<>();
		l1.add(3);
		l1.add(4);
		List<Integer> l3 = new ArrayList<>();
		l1.add(5);
		l1.add(6);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);

		KwayMerge sol = new KwayMerge();
		List<Integer> res = sol.mergeI(lists);
		System.out.println(res);
	}
}
