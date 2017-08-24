package com.tree;

/**
 * Created by Tianran on 1/30/2017.
 */
public class RemoveNodesOutOfRangeInBST {
	public TreeNode removeNodes(TreeNode root, int min, int max) {
		if(root == null) {
			return null;
		}
		root.left = removeNodes(root.left, min, max);
		root.right = removeNodes(root.right, min, max);

		//	if(root.val >= min && root.val <= max) {
//			return root;
// 	}

		if(root.val < min) {
			return root.right;
		}

		if(root.val > max) {
			return root.left;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(8);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		LevelOrderTraversal level = new LevelOrderTraversal();
		level.levelRecursive(n1);

		RemoveNodesOutOfRangeInBST sol = new RemoveNodesOutOfRangeInBST();
		TreeNode res = sol.removeNodes(n1, 4, 5);
		level.levelRecursive(res);
	}
}
