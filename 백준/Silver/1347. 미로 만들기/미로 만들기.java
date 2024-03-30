import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());

        String move = bf.readLine();

        int[][] map = new int[101][101];

        int[] xDir = {0, 1, 0, -1};
        int[] yDir = {1, 0, -1, 0};

        int x = 50;
        int minX = 50;
        int maxX = 50;
        int y = 50;
        int minY = 50;
        int maxY = 50;
        int dir = 1;

        map[x][y] = 1;

        for (int i = 0; i < cnt; i++) {
            char m = move.charAt(i);
            switch (m) {
                case 'L' :
                    dir -= 1;
                    if (dir == -1)
                        dir = 3;
                    break;
                case 'R' :
                    dir = (dir + 1) % 4;
                    break;
                case 'F' :
                    x += xDir[dir];
                    y += yDir[dir];

                    map[x][y] = 1;

                    minX = Math.min(x, minX);
                    maxX = Math.max(x, maxX);
                    minY = Math.min(y, minY);
                    maxY = Math.max(y, maxY);
                    break;
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (map[i][j] == 1)
                    System.out.print(".");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
}