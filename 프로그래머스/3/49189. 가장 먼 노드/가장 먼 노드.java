import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> link = new ArrayList<>();
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n + 1; i++)
            link.add(new ArrayList<>());

        for (int[] e : edge) {
            link.get(e[0]).add(e[1]);
            link.get(e[1]).add(e[0]);
        }

        visited[1] = true;
        q.add(1);

        while (q.size() != 0) {
            int current = q.poll();
            ArrayList<Integer> node = link.get(current);

            for (int nd : node) {
                if (!visited[nd]) {
                    q.add(nd);
                    visited[nd] = true;
                    distance[nd] = distance[current] + 1;
                }
            }
        }

        Arrays.sort(distance);

        int max = distance[n];

        for (int i = n; i >= 0; i--) {
            if (distance[i] == max)
                answer++;
        }

        return answer;
    }
}