import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] values = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            String[] lines = bf.readLine().split(" ");

            int red = Integer.parseInt(lines[0]);
            int green = Integer.parseInt(lines[1]);
            int blue = Integer.parseInt(lines[2]);

            values[i][0] = Math.min(values[i - 1][1], values[i - 1][2]) + red;
            values[i][1] = Math.min(values[i - 1][0], values[i - 1][2]) + green;
            values[i][2] = Math.min(values[i - 1][0], values[i - 1][1]) + blue;
        }
        System.out.println(Math.min(values[n][0], Math.min(values[n][1], values[n][2])));
    }
}