import java.io.*;
import java.util.*;

public class Main {
    static int safeCnt = Integer.MIN_VALUE;
    static int[][] map;
    static int[] xDirection = {0, 0, 1, -1};
    static int[] yDirection = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        map = new int[Integer.parseInt(line[0])][Integer.parseInt(line[1])];

        for (int i = 0; i < map.length; i++) {
            String[] nums = bf.readLine().split(" ");
            for (int j = 0; j < map[0].length; j++)
                map[i][j] = Integer.parseInt(nums[j]);
        }

        dfs(0);

        System.out.println(safeCnt);
    }

    public static void dfs (int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Virus> q = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2)
                    q.add(new Virus(i, j));
            }
        }

        int[][] copyMap = new int[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            copyMap[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            Virus v = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = v.x + xDirection[i];
                int y = v.y + yDirection[i];

                if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
                    if (copyMap[x][y] == 0) {
                        q.add(new Virus(x, y));
                        copyMap[x][y] = 2;
                    }
                }
            }
        }
        int cnt = findZero(copyMap);
        safeCnt = Math.max(safeCnt, cnt);
    }

    public static int findZero (int[][] copyMap) {
        int cnt = 0;
        for (int[] ints : copyMap) {
            for (int j = 0; j < copyMap[0].length; j++) {
                if (ints[j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}

class Virus {
    int x;
    int y;

    public Virus (int x, int y) {
        this.x = x;
        this.y = y;
    }
}