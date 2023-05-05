class Solution {
    int[] dp = new int[100001];
    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != 0) return dp[n] % 1234567;
        dp[n] = solution(n - 2) + solution(n - 1);
        return dp[n] % 1234567;
    }
}