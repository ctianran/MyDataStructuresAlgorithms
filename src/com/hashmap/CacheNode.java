package com.hashmap;

/**
 * Created by Tianran on 2/11/2017.
 */
public class CacheNode<K, V> {
	public K key;
	public V value;
	public CacheNode<K, V> prev;
	public CacheNode<K, V> next;

	public CacheNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public void update(K key, V value) {
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}
