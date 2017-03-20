package com.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tianran on 3/18/2017.
 */
public class RemoveNodesContainsKNodes {
	public TreeNode removeNodes(TreeNode root, List<TreeNode>list) {
		if(root == null) {
			return null;
		}
		Set<TreeNode> set = new HashSet<>();
		for(TreeNode node : list) {
			set.add(node);
		}
		return helper(root, set);
	}

	private TreeNode helper(TreeNode root, Set<TreeNode> set) {
		if(root == null || set.contains(root)) {
			return root;
		}
		root.left = helper(root.left, set);
		root.right = helper(root.right, set);

		if(root.left != null && root.right != null) {
			return root;
		}
		return root.left == null ? root.right : root.left;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		List<TreeNode> list = new ArrayList<>();
		list.add(n3);
		list.add(n6);
		list.add(n7);
		LevelOrderTraversal printTree = new LevelOrderTraversal();
		System.out.println(printTree.level(n1));
		RemoveNodesContainsKNodes sol = new RemoveNodesContainsKNodes();
		TreeNode res = sol.removeNodes(n1, list);
		System.out.println(printTree.level(res));

	}

}
