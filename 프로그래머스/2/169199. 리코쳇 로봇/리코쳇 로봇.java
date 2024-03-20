import java.util.LinkedList;
import java.util.Queue;

class Solution {
    char[] D = {'U', 'D', 'L', 'R'};
    
    public int solution(String[] maps) {
        int[] start = findSpot('R', maps);

        int moveCnt = bfs(start, maps);

        return (moveCnt > 0) ? moveCnt : -1;
    }

    public int bfs(int[] start, String[] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));

        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        visited[start[0]][start[1]] = true;

        int answer = -1; // 기본값 -1로 설정

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (maps[current.start[0]].charAt(current.start[1]) == 'G') {
                answer = current.cnt; // 이동 횟수 업데이트
                break; // 최소 이동 횟수이므로 더 이상 탐색할 필요 없음
            }

            for (char direction : D) {
                int[] move = findStop(direction, current.start, maps);

                int x = move[0];
                int y = move[1];

                if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length() || maps[x].charAt(y) == 'D' || visited[x][y])
                    continue;

                visited[x][y] = true;
                q.offer(new Node(move, current.cnt + 1));
            }
        }
        return answer;
    }

    public int[] findSpot(char find, String[] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == find)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    public int[] findStop(char direction, int[] start, String[] map) {
        int x = start[0];
        int y = start[1];

        switch (direction) {
            case 'U':
                while (x > 0 && map[x - 1].charAt(y) != 'D')
                    x--;
                break;
            case 'D':
                while (x < map.length - 1 && map[x + 1].charAt(y) != 'D')
                    x++;
                break;
            case 'L':
                while (y > 0 && map[x].charAt(y - 1) != 'D')
                    y--;
                break;
            case 'R':
                while (y < map[0].length() - 1 && map[x].charAt(y + 1) != 'D')
                    y++;
                break;
        }

        return new int[]{x, y};
    }
}

class Node {
    int[] start;
    int cnt;

    public Node(int[] start, int cnt) {
        this.start = start;
        this.cnt = cnt;
    }
}