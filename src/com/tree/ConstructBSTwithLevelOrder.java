package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 1/31/2017.
 */
public class ConstructBSTwithLevelOrder {
	public TreeNode construct(int[] level) {
		if(level == null || level.length == 0) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		for(int num : level) {
			list.add(num);
		}
		return helper(list);
	}

	private TreeNode helper(List<Integer> list) {
		if(list.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(list.remove(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for(int num : list) {
			if(num < root.val) {
				left.add(num);
			} else {
				right.add(num);
			}
		}
		root.left = helper(left);
		root.right = helper(right);
		return root;
	}
}
