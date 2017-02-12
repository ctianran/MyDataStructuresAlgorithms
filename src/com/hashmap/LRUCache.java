package com.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/11/2017.
 */
public class LRUCache<K, V> {
	private final int limit;
	private CacheNode<K, V> head;
	private CacheNode<K, V> tail;
	Map<K, CacheNode<K, V>> map;

	public LRUCache(int limit) {
		this.limit = limit;
		this.map = new HashMap<K, CacheNode<K, V>>();
	}

	public void set(K key, V value) {
		CacheNode<K, V> node = null;
		if(map.containsKey(key)) {
			node = map.get(key);
			node.value = value;
			removeNode(node);
		} else if (map.size() < limit) {
			node = new CacheNode(key, value);
		} else {
			node = tail;
			removeNode(tail);
			node.update(key, value);
		}
		insertToHead(node);
	}

	public V get(K key) {
		CacheNode<K, V> node = map.get(key);
		if(node == null) {
			return null;
		}
		removeNode(node);
		insertToHead(node);
		return node.value;
	}

	private CacheNode<K, V> removeNode(CacheNode<K, V> node) {
		map.remove(node.key);
		if(node == head) {
			head = head.next;
		} else if (node == tail) {
			tail = tail.prev;
		}
		if(node.prev != null) {
			node.prev.next = node.next;
		}
		if(node.next != null) {
			node.next.prev = node.prev;
		}
		node.prev = node.next = null;
		return node;
	}

	private CacheNode<K, V> insertToHead(CacheNode<K, V> node) {
		map.put(node.key, node);
		if(head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		return node;
	}
}
