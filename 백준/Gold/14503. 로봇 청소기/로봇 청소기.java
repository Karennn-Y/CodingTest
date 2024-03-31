import java.io.*;

public class Main {
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;

    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        String[] line2 = bf.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        int startX = Integer.parseInt(line2[0]);
        int startY = Integer.parseInt(line2[1]);
        int direction = Integer.parseInt(line2[2]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] tmpMap = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tmpMap[j]);
            }
        }

        int answer = getCnt(startX, startY, direction);

        System.out.println(answer);
    }

    public static int getCnt(int startX, int startY, int direction) {
        int cnt = 0;
        while (true) {
            if (map[startX][startY] == 0) {
                map[startX][startY] = 2;
                cnt++;
            }
            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4;

                int x = startX + directionX[direction];
                int y = startY + directionY[direction];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (map[x][y] == 0) {
                        startX = x;
                        startY = y;
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                int d = (direction + 2) % 4;

                startX += directionX[d];
                startY += directionY[d];

                if (map[startX][startY] == 1)
                    break;
            }
        }
        return cnt;
    }
}