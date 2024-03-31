import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(bf.readLine());
        int loop = Integer.parseInt(bf.readLine());

        graph = new int[nodeCnt + 1][nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        for (int i = 0; i < loop; i++) {
            String[] nodes = bf.readLine().split(" ");

            int x = Integer.parseInt(nodes[0]);
            int y = Integer.parseInt(nodes[1]);

            graph[x][y] = graph[y][x] = 1;
        }
        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs (int start) {
        visited[start] = true;

        if (start == graph.length)
            return;

        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                cnt++;
                dfs(i);
            }
        }
    }
}