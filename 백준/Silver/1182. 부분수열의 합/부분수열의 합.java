import java.io.*;

public class Main {
    static int N, S, cnt = 0;
    static int[] numbers;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);
        numbers = new int[N];
        
        String[] nums = bf.readLine().split(" ");
        
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }
        
        dfs(0, 0);
        
        if (S == 0)
            cnt -= 1;
        
        System.out.println(cnt);
    }
    
    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S)
                cnt++;
            return;
        }
        
        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum);
    }
}