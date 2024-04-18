import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bf.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int D = Integer.parseInt(firstLine[1]);

        ArrayList<ShortCut> shortCuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] lines = bf.readLine().split(" ");
            int s = Integer.parseInt(lines[0]);
            int e = Integer.parseInt(lines[1]);
            int d = Integer.parseInt(lines[2]);

            // 진짜 지름길일 경우에만 넣기
            if (e - s > d)  // 거리가 더 적게 걸리는지
                if (e <= D) // 끝나는 부분이 종점보다 작거나 같은 경우에만 넣기
                    shortCuts.add(new ShortCut(s, e, d));
        }
        // 배열 정렬 하기
        shortCuts.sort(new Comparator<ShortCut>() {
            @Override
            public int compare(ShortCut o1, ShortCut o2) {
                if (o1.start == o2.start) // 시작위치 같은 경우 종료 위치 기준 정렬
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int[] ways = new int[D + 1];
        Arrays.fill(ways, Integer.MAX_VALUE); // 최솟값 비교로 인해
        ways[0] = 0;
        int idx = 0;
        int move = 0;

        while (move < D) {
            if (idx < shortCuts.size()) {
                ShortCut sc = shortCuts.get(idx);
                if (move == sc.start) {// 만약 시작점이 같은 경우 -> 도착 지점 소유 거리 비교후 넣기
                    ways[sc.end] = Math.min(ways[move] + sc.distance, ways[sc.end]);
                    idx++;
                } else { // 같지 않는 경우 (지름길 없는 경우) -> 들어있는 값과 비교후 넣기
                    ways[move + 1] = Math.min(ways[move + 1], ways[move] + 1);
                    move++;
                }
            } else {
                ways[move + 1] = Math.min(ways[move + 1], ways[move] + 1);
                move++;
            }
        }
        System.out.println(ways[D]);
    }
}

class ShortCut {
    int start;
    int end;
    int distance;

    public ShortCut(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}