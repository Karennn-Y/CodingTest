import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        
        int min = getMin(line[0], line[1]);
        int max = getMax(line[0], line[1]);
        
        System.out.println(min + " " + max);
    }

    public static int getMin (String first, String second) {
        if (first.contains("6"))
            first = first.replaceAll("6", "5");
        if (second.contains("6"))
           second = second.replaceAll("6", "5");
        return Integer.parseInt(first) + Integer.parseInt(second);
    }

    public static int getMax(String first, String second) {
        if (first.contains("5"))
            first = first.replaceAll("5", "6");
        if (second.contains("5"))
            second = second.replaceAll("5", "6");
        return Integer.parseInt(first) + Integer.parseInt(second);
    }
}