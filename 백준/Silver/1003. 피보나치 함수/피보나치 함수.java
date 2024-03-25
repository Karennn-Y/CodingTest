import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCnt; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                System.out.println("1 0");
                continue;
            } else if (num == 1) {
                System.out.println("0 1");
                continue;
            }
            
            int[] zeroCnt = new int[num + 1];
            int[] oneCnt = new int[num + 1];

            zeroCnt[0] = 1;
            oneCnt[1] = 1;

            for (int j = 2; j <= num; j++) {
                zeroCnt[j] = zeroCnt[j - 1] + zeroCnt[j - 2];
                oneCnt[j] = oneCnt[j - 1] + oneCnt[j - 2];
            }

            System.out.println(zeroCnt[num] + " " + oneCnt[num]);
        }
    }
}