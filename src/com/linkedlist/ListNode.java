package com.linkedlist;

/**
 * Created by Tianran on 1/26/2017.
 */
public class ListNode {
	public int val;
	public char ch;
	public ListNode next;
	public ListNode prev;
	public ListNode child;
	public ListNode(int val) {
		this.val = val;
		this.next = null;
		this.prev = null;
	}

	public ListNode(char ch) {
		this.ch = ch;
		this.next = null;
	}


}
