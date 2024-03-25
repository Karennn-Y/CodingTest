import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] lines = bf.readLine().split(" ");
        int[] counts = new int[n];
        int[] rooms = new int[n];

        for (int i = 0; i < n; i++) {
            counts[i] = Integer.parseInt(lines[i]);
        }
        for (int i = 1; i <= n; i++) {
            int cnt = counts[i - 1];
            for (int j = 0; j < n; j++) {
                if (cnt == 0) {
                    if (rooms[j] == 0) {
                        rooms[j] = i;
                        break;
                    }
                } else if (rooms[j] == 0){
                    cnt--;
                }
            }
        }

        for (int i = 0; i < n; i++)
            System.out.println(rooms[i]);
    }
}