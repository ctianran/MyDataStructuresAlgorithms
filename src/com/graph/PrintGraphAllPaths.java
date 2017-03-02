package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/1/2017.
 */
public class PrintGraphAllPaths {
	public List<List<Integer>> allPaths(List<GraphNode> graph) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<>();
		for(GraphNode v : graph) {
			helper(v, path, result);
		}
		return result;
	}

	private void helper(GraphNode v, List<Integer> path, List<List<Integer>> result) {
		if(v.state == State.VISITED) {
			return;
		}
		v.state = State.VISITED;
		path.add(v.val);
		result.add(new ArrayList<Integer>(path));
		for(GraphNode n : v.neighbors) {
			helper(n, path, result);
		}
		v.state = State.UNVISITED;
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		GraphNode g1 = new GraphNode(1);
		GraphNode g2 = new GraphNode(2);
		GraphNode g3 = new GraphNode(3);
		GraphNode g4 = new GraphNode(4);
		g1.neighbors.add(g2);
		g1.neighbors.add(g4);
		g2.neighbors.add(g4);
		g3.neighbors.add(g1);
		g4.neighbors.add(g3);

		List<GraphNode> graph = new ArrayList<GraphNode>();
		graph.add(g1);
		graph.add(g2);
		graph.add(g3);
		graph.add(g4);
		PrintGraphAllPaths sol = new PrintGraphAllPaths();
		List<List<Integer>> res = sol.allPaths(graph);
		System.out.println(res);

	}
}
