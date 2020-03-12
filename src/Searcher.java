package src;

import java.util.*;

class Searcher {
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private int target;

    Searcher(int[][] edges, int target) {
        this.target = target;
        for (int i = 0; i < edges.length; i++) {
            while (nodes.size() < Integer.MAX_VALUE / 2000) {
                nodes.add(null);
            }
            if (nodes.get(edges[i][0]) == null) {
                nodes.set(edges[i][0], new Node());
            }
            if (nodes.get(edges[i][1]) == null) {
                nodes.set(edges[i][1], new Node());
            }
            nodes.get(edges[i][0]).addEdge(edges[i][1], edges[i][2]);
            nodes.get(edges[i][1]).addEdge(edges[i][0], edges[i][2]);
        }
    }

    public int search(int start, int previous) {
        Integer[] edges = nodes.get(start).getTargets();
        Integer[] costs = nodes.get(start).getCosts();
        int cost = Integer.MAX_VALUE;
        System.out.println("Edges " + edges.length);
        if (edges.length == 1) {
            return Integer.MAX_VALUE;
        }
        if (start == target) {
            return 0;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != previous) {
                System.out.println("Trying path to " + edges[i] + ". Cost is: " + costs[i]);
                int temp = costs[i] + search(edges[i], start);
                if (temp < cost) {
                    cost = temp;
                }
            }
        }
        return cost;
    }

}