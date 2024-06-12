import java.util.*;

class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    int[][] distance;
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        int i = maps.length;
        int j = maps[0].length;
        
         // if (maps[i - 1][j - 2] == 0 && maps[i - 2][j - 1] == 0)
         //    return -1;
        
        distance = new int[i][j];
        visited = new boolean[i][j];
        
        distance[0][0] = 1;
        Position start = new Position(0, 0);
        
        bfs(maps, start);
        
        return (distance[i - 1][j - 1] == 0) ? -1 : distance[i - 1][j - 1];
    }
    
    public void bfs (int[][] maps, Position position) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(position);
        visited[position.x][position.y] = true;

        while(!queue.isEmpty()) {
            Position current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = current.x + dirX[i];
                int y = current.y + dirY[i];

                if (x < 0 || x >= maps.length ||
                    y < 0 || y >= maps[0].length || 
                    maps[x][y] == 0 || visited[x][y])
                    continue;
                visited[x][y] = true;
                distance[x][y] = distance[current.x][current.y] + 1;
                queue.add(new Position(x, y));
            }
        }
    }
}

class Position {
    int x;
    int y;
    
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }
}