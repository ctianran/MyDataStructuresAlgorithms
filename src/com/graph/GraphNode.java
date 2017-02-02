package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 1/31/2017.
 */
public class GraphNode {
	int val;
	List<GraphNode> neighbors;
	public GraphNode(int val) {
		this.val = val;
		neighbors = new ArrayList<GraphNode>();
	}
}
