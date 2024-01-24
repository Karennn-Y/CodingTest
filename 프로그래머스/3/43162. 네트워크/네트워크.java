import java.util.*;

class Solution {
    Queue<Integer> que = new LinkedList<>();
    boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if (!visited[i]) {
                answer++;
                BFS(i, computers, n);
            }
        }
        return answer;
    }
    
    public void BFS(int idx, int[][] computers, int n) {
        que.offer(idx);
        visited[idx] = true;
        
        while(!que.isEmpty()) {
            int value = que.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && computers[value][i] == 1) {
                    visited[i] = true;
                    BFS(i, computers, n);
                }
            }
        }
    }
}