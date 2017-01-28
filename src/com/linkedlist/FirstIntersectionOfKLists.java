package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 1/27/2017.
 */
public class FirstIntersectionOfKLists {
	public ListNode firstNode(ListNode[] lists) {
		if(lists.length <= 1) {
			return null;
		}
		Map<ListNode, Integer> map = new HashMap<>();

		for(int i = 0; i < lists.length; i++) {
			ListNode head = lists[i];

			while(head != null) {
				if(i == lists.length - 1) {
					if(map.containsKey(head) && map.get(head) == lists.length - 1) {
						return head;
					}
				} else{
					Integer count = map.get(head);
					if(count == null) {
						map.put(head, 1);
					} else {
						map.put(head, count + 1);
					}
				}
				head = head.next;
			}
		}
		return null;
	}
}
