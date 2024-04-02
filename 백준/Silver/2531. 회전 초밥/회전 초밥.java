import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bf.readLine().split(" ");

        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[2]);
        int eventNum = Integer.parseInt(lines[3]);

        int[] lane = new int[n];
        int answer = Integer.MIN_VALUE;

        for (int i =0; i < n; i++) {
            lane[i] = Integer.parseInt(bf.readLine());
        }

        HashSet<Integer> tummy = new HashSet<>();

        for (int i = 0; i < n; i++) {
            tummy.clear();
            for (int j = 0; j < k; j++) {
                int idx = (i + j) % n;
                tummy.add(lane[idx]);
            }
            tummy.add(eventNum);
            answer = Integer.max(answer, tummy.size());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer +"\n");
        bw.flush();
        bw.close();
    }
}