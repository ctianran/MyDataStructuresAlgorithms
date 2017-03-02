package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/1/2017.
 */
public class PrintBinaryTreeAllPaths {
	public List<List<Integer>> allPaths(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<>();
		allPaths(root, path, result);
		return result;
	}
	private void allPaths(TreeNode root, List<Integer> path, List<List<Integer>> result) {
		if(root == null) {
			return;
		}
		path.add(root.val);
		result.add(new ArrayList<Integer>(path));
		allPaths(root.left, path, result);
		allPaths(root.right, path, result);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(8);
		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;

		PrintBinaryTreeAllPaths sol = new PrintBinaryTreeAllPaths();
		List<List<Integer>> res = sol.allPaths(n1);
		System.out.println(res);
	}
}
