package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 1/28/2017.
 */
public class DeepCopyLinkedList {
	public RandomListNode copyI(RandomListNode head) {
		if(head == null) {
			return head;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode prev = dummy;
		RandomListNode cur = head;
		while(cur != null) {
			if(!map.containsKey(cur)) {
				map.put(cur, new RandomListNode(cur.val));
			}
			prev.next = map.get(cur);
			if(cur.random != null) {
				if(!map.containsKey(cur.random)) {
					map.put(cur.random, new RandomListNode(cur.random.val));
				}
				prev.next.random = map.get(cur.random);
			}
			cur = cur.next;
			prev = prev.next;
		}
		return dummy.next;
	}

	public RandomListNode copyII(RandomListNode head) {
		if(head == null) {
			return null;
		}
		RandomListNode cur = head;
		while(cur != null) {
			RandomListNode next = cur.next;
			cur.next = new RandomListNode(cur.val);
			cur.next.next = next;
			cur = next;
		}

		cur = head;
		while(cur != null) {
			if(cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		cur = head;
		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head;
		RandomListNode prev = dummy;

		while(cur != null) {
				prev.next = cur.next;
				cur.next = cur.next.next;
				prev = prev.next;
				cur = cur.next;
		}
		return dummy.next;
	}
}
