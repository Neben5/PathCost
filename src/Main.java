package src;

public class Main {
    public static void main(String... args) throws Exception {
        new Main();
    }

    private int target;

    Main() throws Exception {
        int[][] lines = Reader.read();
        target = lines[0][0];
        int[][] edges = new int[lines.length - 1][3];
        for (int i = 1; i < lines.length; i++) {
            edges[i - 1] = lines[i];
        }
        Searcher searcher = new Searcher(edges, target);
        System.out.println("Target: " + target);
        System.out.println("Solution: " + searcher.search(1, 1));

    }
}