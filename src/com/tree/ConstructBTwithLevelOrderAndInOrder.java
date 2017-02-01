package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 1/31/2017.
 */
public class ConstructBTwithLevelOrderAndInOrder {
	public TreeNode construc(int[] level, int in[]) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < level.length; i++) {
			list.add(level[i]);
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return helper(list, map);
	}

	private TreeNode helper(List<Integer> list, Map<Integer, Integer> map) {
		if(list.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(list.remove(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for(int num : list) {
			if(map.get(num) < map.get(root.val)) {
				left.add(num);
			} else {
				right.add(num);
			}
		}
		root.left = helper(left, map);
		root.right = helper(right, map);
		return root;
	}
}
