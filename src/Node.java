package src;

import java.util.ArrayList;

public class Node {
    private ArrayList<Edge> paths = new ArrayList<>();
    private int nodeNumber;

    public Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Edge addEdge(Edge e) {
        paths.add(e);
        return e;
    }

    public boolean removeEdge(Edge e) {
        return paths.remove(e);
    }

    public Edge[] getEdges() {
        Edge[] arr = new Edge[paths.size()];
        arr = paths.toArray(arr);
        return arr;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }
}