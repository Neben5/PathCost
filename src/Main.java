package src;

public class Main {
    public static void main(String... args) throws Exception {
        new Main();
    }

    private int target;
    private int vertices;

    Main() throws Exception {
        int[][] lines = Reader.read();
        target = lines[0][0];
        vertices = lines[0][1];
        int[][] edges = new int[lines.length - 1][3];
        for (int i = 1; i < lines.length; i++) {
            edges[i - 1] = lines[i];
        }
        /*
         * Searcher searcher = new Searcher(edges, target);
         * System.out.println(searcher.search(1, 1));
         */
        int[][] graph = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = Integer.MAX_VALUE-1000000;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int[] currentEdge = edges[i];
            if (currentEdge[2] < graph[currentEdge[0]-1][currentEdge[1]-1]) {
                graph[currentEdge[0]-1][currentEdge[1]-1] = currentEdge[2];
                graph[currentEdge[1]-1][currentEdge[0]-1] = currentEdge[2];
            }
        }
        ShortestPath path = new ShortestPath(vertices);
        path.dijkstra(graph, 0, target);

    }
}