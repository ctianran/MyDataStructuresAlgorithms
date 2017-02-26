package com.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Tianran on 2/25/2017.
 */
public class LowestCommonAncestor {
	//two nodes are guaranteed in the tree
	public TreeNode LCARecI(TreeNode root, TreeNode one, TreeNode two) {
		if(root == null || root == one || root == two) {
			return root;
		}
		TreeNode left = LCARecI(root.left, one, two);
		TreeNode right = LCARecI(root.right, one, two);
		if(left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
	//two nodes are not guaranteed in the tree
	//return null if either one of the node are not in the tree
	public TreeNode LCARecII(TreeNode root, TreeNode one, TreeNode two) {
		boolean[] found = new boolean[2];
		TreeNode cur = LCARecIIhelper(root, one, two, found);
		if(cur != null) {
			if(found[0] && found[1]) {
				return cur;
			}
		}
		return null;
	}

	private TreeNode LCARecIIhelper(TreeNode root, TreeNode one, TreeNode two, boolean[] found) {
		if(root == null) {
			return null;
		}

		if(root == one) {
			found[0] = true;
			if(!found[1]) {
				LCARecIIhelper(root.left, one, two, found);
				LCARecIIhelper(root.right, one, two, found);
			}
			return root;
		} else if (root == two) {
			found[1] = true;
			if(!found[0]) {
				LCARecIIhelper(root.left, one, two, found);
				LCARecIIhelper(root.right, one, two, found);
			}
			return root;
		}

		TreeNode left = LCARecIIhelper(root.left, one, two, found);
		TreeNode right = LCARecIIhelper(root.right, one, two, found);
		if(left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	public TreeNode LCAIter(TreeNode root, TreeNode one, TreeNode two) {
		if(root == null || root == one || root == two) {
			return root;
		}
		Map<TreeNode, TreeNode> map = new HashMap<>();
		int heightOne = getHeight(root, one, map);
		int heightTwo = getHeight(root, two, map);
		if(heightOne == -1 || heightTwo == -1) {
			return null;
		}
		int diff = Math.abs(heightOne - heightTwo);
		if(heightOne > heightTwo) {
			while(diff > 0) {
				one = map.get(one);
				diff--;
			}
		} else if (heightOne < heightTwo) {
			while(diff > 0) {
				two = map.get(two);
				diff--;
			}
		}
		while(one != two) {
			one = map.get(one);
			two = map.get(two);
		}
		return one;
	}

	private int getHeight(TreeNode root, TreeNode node, Map<TreeNode, TreeNode> map) {
		int height = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if(cur == node) {
					return height;
				}
				if(cur.left != null) {
					queue.offer(cur.left);
					if(!map.containsKey(cur.left)) {
						map.put(cur.left, cur);
					}
				}
				if(cur.right != null) {
					queue.offer(cur.right);
					if(!map.containsKey(cur.right)) {
						map.put(cur.right, cur);
					}
				}
			}
			height++;
		}
		return -1;
	}
}
