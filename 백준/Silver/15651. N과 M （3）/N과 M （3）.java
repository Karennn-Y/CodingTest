import java.io.*;

public class Main {
    static int[] arr;
    static BufferedWriter bw;
    static int N, D;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        D = Integer.parseInt(line[1]);
        arr = new int[D];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dfs(0);
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth) throws  IOException{
        StringBuilder sb = new StringBuilder();
        if (depth == D) {
            for (int n : arr)
                sb.append(n).append(" ");
            bw.write(sb + "\n");
        } else {
           for (int i = 1; i <= N; i++) {
               arr[depth] = i;
               dfs(depth + 1);
            }
        }
    }
}