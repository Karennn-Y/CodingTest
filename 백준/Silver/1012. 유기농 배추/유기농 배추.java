import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] line = bf.readLine().split(" ");
            int[][] field = new int[Integer.parseInt(line[0])][Integer.parseInt(line[1])];
            for (int j = 0; j < Integer.parseInt(line[2]); j++) {
                String[] spot = bf.readLine().split(" ");
                field[Integer.parseInt(spot[0])][Integer.parseInt(spot[1])] = 1;
            }
            int total = getCount(field);
            System.out.println(total);
        }
    }

     public static int getCount (int[][] field) {
        int cnt = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1) {
                    field[i][j] = 0;
                    Spot start = new Spot(i, j);
                    cnt += bfs(start, field);
                }
            }
        }
        return cnt;
    }

    public static int bfs (Spot spot, int[][] field) {
        Queue<Spot> q = new LinkedList<>();
        q.offer(spot);
        boolean[][] visited = new boolean[field.length][field[0].length];
        visited[spot.x][spot.y] = true;

        while (!q.isEmpty()) {
            Spot current = q.poll();

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

                if (x < 0 || y < 0 || x >= field.length || y >= field[0].length || field[x][y] == 0 || visited[x][y])
                    continue;

                visited[x][y] = true;
                field[x][y] = 0;

                q.offer(new Spot(x, y));
            }
        }
        return 1;
    }
}

class Spot {
    int x;
    int y;

    public Spot (int x, int y) {
        this.x = x;
        this.y = y;
    }
}