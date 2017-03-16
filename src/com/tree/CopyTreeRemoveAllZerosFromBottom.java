package com.tree;

import java.util.List;

/**
 * Created by Tianran on 3/15/2017.
 */
public class CopyTreeRemoveAllZerosFromBottom {
	public TreeNode copyTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		root.left = copyTree(root.left);
		root.right = copyTree(root.right);
		if(root.left == null && root.right == null && root.val == 0) {
			return null;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(1);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;


		CopyTreeRemoveAllZerosFromBottom sol = new CopyTreeRemoveAllZerosFromBottom();
		TreeNode res = sol.copyTree(n1);

		LevelOrderTraversal sol1 = new LevelOrderTraversal();
		List<Integer> printRes = sol1.level(res);
		System.out.println(printRes);
 	}
}
