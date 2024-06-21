import java.util.*;

class Solution {
    boolean[] visited;
    Queue<String> arrivals;
    
    public String[] solution(String[][] tickets) {
        int cnt = 0;
        visited = new boolean[tickets.length];
        arrivals = new PriorityQueue<>();

        dfs("ICN", "ICN", tickets, cnt);

        return arrivals.poll().split(" ");
    }

    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            arrivals.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1]
                    , tickets, cnt + 1 );
                visited[i] = false;
            }
        }
    }
}