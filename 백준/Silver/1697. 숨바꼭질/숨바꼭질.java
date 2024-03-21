import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);
        
        System.out.println(solution(start, end));
    }
    
    public static int solution(int start, int end) {
        if (start == end) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));

        boolean[] visited = new boolean[300000];
        visited[start] = true;

        int answer = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.current == end) {
                answer = current.cnt;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int move = findStop(i, current.current);

                if (move < 0 || move >= visited.length || visited[move])
                    continue;
                visited[move] = true;
                q.offer(new Node(move, current.cnt + 1));
            }
        }

        return answer;
    }

     public static int findStop(int direction, int spot) {
        switch (direction) {
            case 0 :
                return spot + 1;
            case 1 :
                return spot - 1;
            case 2 :
                return spot * 2;
        }
        return 0;
    }
}

class Node {
    int current;
    int cnt;
    
    public Node (int current, int cnt) {
        this.current = current;
        this.cnt = cnt;
    }
}