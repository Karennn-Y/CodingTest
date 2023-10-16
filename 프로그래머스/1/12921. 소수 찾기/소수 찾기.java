import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] primeList = new boolean[n + 1];
        Arrays.fill(primeList, true);
        
        primeList[0] = false;
        primeList[1] = false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) 
            if (primeList[i])
                for(int j = i * i; j <= n; j+= i)
                    primeList[j] = false;
        
        for (boolean b : primeList)
            if(b) answer++;
        
        return answer;
    }
}