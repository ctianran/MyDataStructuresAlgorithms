package com.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Tianran on 1/31/2017.
 */
public class PeekingIterator {

	private Integer peekVal = null;
	private Iterator<Integer> iter;
	public PeekingIterator(List<Integer> input) {
		if(input.size() == 0) {
			return;
		}
		this.iter = input.iterator();
		if(iter.hasNext()) {
			peekVal = iter.next();
		}
	}

	public boolean hasNext() {
		return peekVal != null;
	}

	public Integer next() {
		Integer res = peekVal;
		peekVal = iter.hasNext() ? iter.next() : null;
		return res;
	}
}
