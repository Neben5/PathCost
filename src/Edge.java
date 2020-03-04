package src;

public class Edge {
    private int nodeA;
    private int nodeB;
    private int cost;

    public Edge(int nodeA, int nodeB, int cost) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.cost = cost;
    }

    public boolean isBetter(Edge e) {
        if (e.getCost() < this.getCost()) {
            return false;
        }
        return true;
    }

    public int getNodeA() {
        return nodeA;
    }

    public void setNodeA(int nodeA) {
        this.nodeA = nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public void setNodeB(int nodeB) {
        this.nodeB = nodeB;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(Edge.class)) {
            Edge e = (Edge) obj;
            if (e.getNodeA() == this.getNodeA() && e.getNodeB() == this.getNodeB()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Edge[" + nodeA + ", " + nodeB + ", " + cost + ']';
    }
}