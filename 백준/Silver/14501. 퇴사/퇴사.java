import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] t = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");
            t[i] = Integer.parseInt(line[0]);
            p[i] = Integer.parseInt(line[1]);
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}