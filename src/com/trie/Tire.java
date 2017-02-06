package com.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 2/5/2017.
 */
public class Tire {
	private final TrieNode root;

	public Tire() {
		root = new TrieNode();
	}

	public boolean search(String word) {
		TrieNode node = searchNode(word);
		return node != null && node.isEnd;
	}

	private TrieNode searchNode(String word) {
		if(word == null || word.length() == 0) {
			return null;
		}
		TrieNode cur = root;
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode child = cur.children.get(ch);
			if(child == null) {
				return null;
			} else {
				cur = child;
			}
		}
		return cur;
	}

	public void insert(String word) {
		if (word == null) {
			return;
		}
		TrieNode cur = root;
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode child = cur.children.get(ch);
			if(child == null) {
				child = new TrieNode();
				cur.children.put(ch, child);
			}
			cur = child;
		}
		cur.isEnd = true;
	}

	public boolean delete(String word) {
		if(!search(word)) {
			return false;
		}
		TrieNode cur = root;
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			cur.count--;
			if (cur.count == 0) {
				cur.children.remove(ch);
				return true;
			}
			cur = cur.children.get(ch);
		}
		cur.isEnd = false;
		return true;
	}

	public List<String> findAllWithPrefix(String prefix) {
		TrieNode node = searchNode(prefix);
		List<String> result = new ArrayList<>();
		if(node == null) {
			return result;
		}
		StringBuilder sb = new StringBuilder(prefix);
		findAllByDFS(node, sb, result);
		return result;
	}

	private void findAllByDFS(TrieNode node, StringBuilder sb, List<String> result) {
		if(node.isEnd) {
			result.add(sb.toString());
		}
		for(Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
			sb.append(child.getKey());
			findAllByDFS(child.getValue(), sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public List<String> findAllMatchWildCard(String word) {
		List<String> result = new ArrayList<>();
		if(word == null || word.isEmpty()) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		findAllMatchWildCardDFS(root, word, 0, sb, result);
		return result;
	}

	private void findAllMatchWildCardDFS(TrieNode cur, String word, int index, StringBuilder sb, List<String> result) {
		if(index == word.length()) {
			if(cur.isEnd) {
				result.add(sb.toString());
			}
			return;
		}

		char ch = word.charAt(index);
		if(ch == '?') {
			for(Map.Entry<Character, TrieNode> child : cur.children.entrySet()) {
				sb.append(child.getKey());
				findAllMatchWildCardDFS(child.getValue(), word, index + 1, sb, result);
				sb.deleteCharAt(sb.length() - 1);
			}
		} else {
			TrieNode child = cur.children.get(ch);
			if(child != null) {
				sb.append(ch);
				findAllMatchWildCardDFS(child, word, index + 1, sb, result);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

	}

}
