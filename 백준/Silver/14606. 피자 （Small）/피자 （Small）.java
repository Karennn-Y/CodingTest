import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);

        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == 1) {
                continue;
            }

            int x = n / 2;
            if (n % 2 == 0) {
                queue.offer(x);
                queue.offer(x);

                answer += (x * x);
            } else {
                int x1 = x + 1;

                queue.offer(x);
                queue.offer(x1);

                answer += (x * x1);
            }
        }
        System.out.println(answer);
    }
}