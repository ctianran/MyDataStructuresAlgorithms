package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 1/31/2017.
 */
public class GraphNode {
	int val;
	List<GraphNode> neighbors;
	State state;
	public GraphNode(int val) {
		this.val = val;
		state = State.UNVISITED;
		neighbors = new ArrayList<GraphNode>();
	}
}
