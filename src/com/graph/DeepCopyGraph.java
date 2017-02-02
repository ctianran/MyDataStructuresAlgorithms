package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 1/31/2017.
 */
public class DeepCopyGraph {
	public List<GraphNode> copyGraph(List<GraphNode> graph) {
		if(graph == null) {
			return null;
		}
		Map<GraphNode, GraphNode> map = new HashMap<>();
		for(GraphNode node : graph) {
			if(!map.containsKey(node)) {
				map.put(node, new GraphNode(node.val));
				helper(node, map);
			}
		}
		return new ArrayList<GraphNode>(map.values());
	}

	private void helper(GraphNode node, Map<GraphNode, GraphNode> map) {
		GraphNode copy = map.get(node);
		for(GraphNode nei : node.neighbors) {
			if(!map.containsKey(nei)) {
				map.put(nei, new GraphNode(nei.val));
				helper(nei, map);
			}
			copy.neighbors.add(map.get(nei));
		}
	}
}
