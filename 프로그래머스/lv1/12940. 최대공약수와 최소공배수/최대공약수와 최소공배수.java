class Solution {
    public int[] solution(int n, int m) {
        int num1 = 0;
        for (int i = 1; i <= n && i <= m; i++) 
            if (n % i == 0 && m % i == 0) 
                num1 = i;
 
        return new int[]{num1, (n * m) / num1};
    }
}