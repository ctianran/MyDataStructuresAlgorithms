package com.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 1/27/2017.
 */
public class RemoveVowelsInLinkedList {
	public ListNode removeVowels(ListNode head) {
		if(head == null) {
			return null;
		}
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');

		ListNode dummy = new ListNode(' ');
		dummy.next = head;
		ListNode cur = dummy;
		while(cur.next != null) {
			if(set.contains(cur.next.val)) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

}
