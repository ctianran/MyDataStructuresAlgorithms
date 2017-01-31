package com.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tianran on 1/30/2017.
 */
public class PathSumToTarget {
	public boolean existI(TreeNode root, int target) {
		if(root == null) {
			return false;
		}
		List<TreeNode> path = new ArrayList<>();
		return helperI(root, path, target);
	}

	private boolean helperI(TreeNode root, List<TreeNode> path, int target) {
			path.add(root);
			int temp = 0;
			for(int i = path.size() - 1; i >= 0; i--) {
				temp += path.get(i).val;
				if(temp == target) {
					return true;
				}
			}
			if(root.left != null && helperI(root.left, path, target)) {
				return true;
			}
			if(root.right != null && helperI(root.right, path, target)) {
				return true;
			}
			path.remove(path.size() - 1);
			return false;
	}

	public boolean existII(TreeNode root, int target) {
		if(root == null) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		set.add(0);
		return helperII(root, set, 0, target);
	}

	private boolean helperII(TreeNode root, Set<Integer> set, int prefixSum, int target) {
		prefixSum += root.val;
		if(set.contains(prefixSum - target)) {
			return true;
		}
		boolean needRemove = set.add(prefixSum);
		if(root.left != null && helperII(root.left, set, prefixSum, target)) {
			return true;
		}
		if(root.right != null && helperII(root.right, set, prefixSum, target)) {
			return true;
		}
		if(needRemove) {
			set.remove(prefixSum);
		}
		return false;
	}
}
