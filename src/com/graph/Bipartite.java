package com.graph;

import java.util.*;

/**
 * Created by Tianran on 1/31/2017.
 */
public class Bipartite {
	public boolean isBipartite(List<GraphNode> graph) {
		if(graph == null || graph.size() == 0) {
			return false;
		}
		Map<GraphNode, Integer> map = new HashMap<GraphNode, Integer>();
		for(GraphNode node : graph) {
			if(!helper(node, map)) {
				return false;
			}
		}
		return true;
	}

	private boolean helper(GraphNode node, Map<GraphNode, Integer> map) {
		if(map.containsKey(node)) {
			return true;
		}
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(node);
		map.put(node, 0);

		while(!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroup = map.get(cur);
			int neiGroup = curGroup == 0 ? 1 : 0;
			for(GraphNode nei : cur.neighbors) {
				if(!map.containsKey(nei)) {
					map.put(nei, neiGroup);
					queue.offer(nei);
				} else if(map.get(nei) != neiGroup) {
					return false;
				}
			}
		}
		return true;
	}
}
