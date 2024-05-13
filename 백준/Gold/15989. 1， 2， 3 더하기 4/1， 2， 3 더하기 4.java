import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        int[][] dp = new int[100001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(bf.readLine());
            getCnt(dp, num);
            System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
        }
    }

    public static void getCnt(int[][] dp, int num) {
        for (int i = 4; i <= num; i++) {
            dp[i][1] = 1;
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
    }
}