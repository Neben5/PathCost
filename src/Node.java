package src;

import java.util.ArrayList;

public class Node {
    public ArrayList<Integer> targets = new ArrayList<>();
    public ArrayList<Integer> costs = new ArrayList<>();

    Node() {
        super();
    }

    public void addEdge(int target, int cost) {
        targets.add(target);
        costs.add(cost);
    }

    public Integer[] getTargets() {
        Integer[] ret = new Integer[targets.size()];
        for (int i = 0; i < targets.size(); i++) {
            ret[i] = targets.get(i);
        }
        return ret;
    }

    public Integer[] getCosts() {
        Integer[] ret = new Integer[costs.size()];
        for (int i = 0; i < costs.size(); i++) {
            ret[i] = costs.get(i);
        }
        return ret;
    }

}