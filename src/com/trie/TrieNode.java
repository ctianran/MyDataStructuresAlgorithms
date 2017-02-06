package com.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/5/2017.
 */
public class TrieNode {
	boolean isEnd;
	int count;
	Map<Character, TrieNode> children;
	public TrieNode() {
		count = 0;
		isEnd = false;
		children = new HashMap<Character, TrieNode>();
	}
}
