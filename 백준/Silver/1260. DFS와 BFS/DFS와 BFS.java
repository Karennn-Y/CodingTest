import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int start = Integer.parseInt(line[2]);

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] nodes = bf.readLine().split(" ");
            int x = Integer.parseInt(nodes[0]);
            int y = Integer.parseInt(nodes[1]);

            graph[x][y] = graph[y][x] = 1;
        }

        visited = new boolean[N + 1];
        dfs(start);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(start);
    }

    public static void dfs (int start) {
        visited[start] = true;
        System.out.print(start + " ");

        if (start == graph.length)
            return;

        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void bfs (int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 1; i < graph.length; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    q.offer(i);
                }
            }
        }
    }
}