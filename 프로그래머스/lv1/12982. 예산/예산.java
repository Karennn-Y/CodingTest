import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        for (int team : d) {
            if (budget < team) return answer;
            budget -= team;
            answer++;
        }
        return answer;
    }
}