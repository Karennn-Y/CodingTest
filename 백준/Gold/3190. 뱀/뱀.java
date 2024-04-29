import java.util.*;
import java.io.*;

public class Main {
    static int[] xDirection = {0, 1, 0, -1};
    static int[] yDirection = {1, 0, -1, 0};
    static int[][] map;
    static int N;
    static HashMap<Integer, String> directionChange = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        
        // 사과 넣기
        int cnt = Integer.parseInt(bf.readLine());
        for (int i = 0; i <cnt; i++) {
            String[] line = bf.readLine().split(" ");
            map[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] = 1;
        }

        // 움직인 방향 담기
        cnt = Integer.parseInt(bf.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] line = bf.readLine().split(" ");
            directionChange.put(Integer.parseInt(line[0]), line[1]);
        }
        getTime();
    }

    public static void getTime() {
        Queue<Points> snake = new LinkedList<>();
        // 현재 위치 넣어주기
        snake.add(new Points(0, 0));
        // 시간
        int time = 0;
        // 이동 위치
        int dir = 0;
        // 현재 위치
        Points current = new Points(0, 0);
        
        while (true) {
            // 이동 위치, 시간 증가
            Points newPos = new Points(current.x + xDirection[dir], current.y + yDirection[dir]);
            time++;

            // 벽 || 몸통인 경우 -> while 문 탈출
            if (newPos.x < 0 || newPos.x >= N || newPos.y < 0 || newPos.y >= N || map[newPos.x][newPos.y] == 2)
                break;
            // 시과가 아닌 경우
            if (map[newPos.x][newPos.y] != 1) {
                // 꼬리 빼주고 앞으로 한칸 옮길 준비
                Points tail = snake.poll();
                map[tail.x][tail.y] = 0;
            }
            // 새로 움직인 부분 넣어주기
            snake.add(newPos);
            // 움직인 부분 표시해 주기
            map[newPos.x][newPos.y] = 2;

            // 방향 바꿔야 되는지 확인
            if (directionChange.containsKey(time)) {
                String direction = directionChange.get(time);
                if (direction.equals("L")) // 왼쪽일 경우
                    dir = (dir == 0) ? 3 : dir - 1;
                else // 오른쪽일 경우
                    dir = (dir == 3) ? 0 : dir + 1;
            }
            // current 위치 변경 해주기
            current.x = newPos.x;
            current.y = newPos.y;
        }
        System.out.println(time);
    }
}
class Points {
    int x;
    int y;

    public Points (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
