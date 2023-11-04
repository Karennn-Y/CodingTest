import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        int answer = 0;
    
        for (int i = B.length - 1; i >= 0; i--)
            answer += (B[i] * A[idx++]);
        
        return answer;
    }
}