import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Reader {
    String path;
    long startTime;

    public static void main(String args[]) throws IOException {
        Reader main = new Reader();
    }

    public Reader() throws IOException {

    }
    /**
     * starts measuring time
     */
    public void start() {
        startTime = System.nanoTime();
    }
    /**
     * compares current time to start time, prints diff
     */
    public void end() {
        long endTime = System.nanoTime();
        long execTime = (endTime - startTime);
        System.out.println("Took : " + execTime / (long) 1000000000 + " second(s)");
    }
    /**
     * writes into output.txt in same file directory as previous write
     * @param results things to write
     * @throws IOException
     */
    public void write(String[] results) throws IOException {
        Pattern pattern = Pattern.compile("\\\\|/");
        String[] pathParts = pattern.split(path);
        String outPath = "";
        char separator = '/';
        if (System.getProperty("os.name").startsWith("Windows")) {
            separator = '\\';
        }
        for (int i = 0; i < pathParts.length - 1; i++) {
            outPath += pathParts[i] + separator;
        }
        outPath += "output.txt";
        System.out.println(outPath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(outPath));
        for (String st : results) {
            writer.write(st);
            writer.newLine();
        }
        writer.close();
    }

    /**
     * @return file lines split by space
     * @throws IOException
     */
    private String[][] read() throws IOException {
        path = getInput();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
        ArrayList<String> outList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            outList.add(line);
        }
        String[] lines = new String[outList.size()];
        for (int i = 0; i < outList.size(); i++) {
            lines[i] = outList.get(i);
        }
        br.close();
        String[][] arrays = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            arrays[i] = lines[i].split("\\s");
        }
        return arrays;
    }

    /**
     * gets the path for read file
     * 
     * @return filepath
     */
    private String getInput() {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Enter (full) file path. Note that an output file will be created or overwritten in this directory");
        String out = in.nextLine();
        in.close();
        return out;
    }

}
