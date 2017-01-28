package com.mocks;

import com.tree.TreeNode;

/**
 * Created by Tianran on 1/28/2017.
 */
public class TwoSumInBST {
	public boolean twoSum(TreeNode root, int target) {
		if(root == null) {
			return false;
		}
		TreeNode[] prev = new TreeNode[] {null};
		TreeNode[] head = new TreeNode[] {null};
		helper(root, prev, head);
		TreeNode left = head[0];
		TreeNode right = left;
		while(right.right != null) {
			right = right.right;
		}

		while(left != right) {
			int sum = left.val + right.val;
			if(sum == target) {
				return true;
			} else if (sum < target) {
				left = left.right;
			} else {
				right = right.left;
			}
		}
		return false;
	}

	private void helper(TreeNode root, TreeNode[] prev, TreeNode[] head) {
		if(root == null) {
			return;
		}
		helper(root.left, prev, head);
		if(prev[0] == null) {
			head[0] = root;
		} else {
			prev[0].right = root;
			root.left = prev[0];
		}
		prev[0] = root;
		helper(root.right, prev, head);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;

		TwoSumInBST sol = new TwoSumInBST();
		boolean res = sol.twoSum(root, 13);
		System.out.println(res);
	}
}
