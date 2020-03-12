package src;

import java.util.ArrayList;

public class Main {
    public static void main(String... args) throws Exception {
        new Main();
    }

    private int target;

    Main() throws Exception {
        int[][] lines = Reader.read();
        target = lines[0][1];
        Edge[] edges = new Edge[lines.length - 1];
        for (int i = 1; i < lines.length; i++) {
            edges[i-1] = new Edge(lines[i][0], lines[i][1], lines[i][2]);
        }


    }
}