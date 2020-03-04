package src;

public class Main {
    public static void main(String... args) throws Exception {
        new Main();
    }
    private int target;
    Main() throws Exception {
        int[][] lines = Reader.read();
        target = lines[0][1];
    }
}