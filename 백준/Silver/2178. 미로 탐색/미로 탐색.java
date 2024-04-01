import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    public static void main (String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bf.readLine().split(" ");

        N = Integer.parseInt(lines[0]);
        M = Integer.parseInt(lines[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        visited[0][0] = true;

        for (int i = 0; i < N; i++) {
            String[] numbers = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        bfs(new StartPoint(0, 0));

        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs (StartPoint start) {
        Queue<StartPoint> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            StartPoint current = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = 0;
                int y = 0;

                switch (i) {
                    case 0 :
                        x = current.x - 1;
                        y = current.y;
                        break;
                    case 1 :
                        x = current.x + 1;
                        y = current.y;
                        break;
                    case 2 :
                        x = current.x;
                        y = current.y - 1;
                        break;
                    case 3 :
                        x = current.x;
                        y = current.y + 1;
                        break;
                }

                if(x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 0 || visited[x][y])
                    continue;
                visited[x][y] = true;
                map[x][y] = map[current.x][current.y] + 1;
                q.offer(new StartPoint(x, y));
            }
        }
    }
}

class StartPoint {
    int x;
    int y;

    public StartPoint (int x, int y) {
        this.x = x;
        this.y = y;
    }
}