package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 8/21/2017.
 */
public class CollectAndRemoveAllLeafNodes {
	static class TreeNode {
		int val;
		int height;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public List<Integer> removeLeafNodes(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		helper(root, res);
		return res;
	}

	private TreeNode helper(TreeNode root, List<Integer> res) {
		if(root == null) {
			return root;
		}
		root.left = helper(root.left, res);
		root.right = helper(root.right, res);

		if(root.left == null && root.right == null) {
			res.add(root.val);
			return null;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		CollectAndRemoveAllLeafNodes sol = new CollectAndRemoveAllLeafNodes();
		List<Integer> res = sol.removeLeafNodes(n1);
		System.out.println(res);
	}
}
