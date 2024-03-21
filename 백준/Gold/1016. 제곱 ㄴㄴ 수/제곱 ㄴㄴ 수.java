import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String min = line.split(" ")[0];
        String max = line.split(" ")[1];

        System.out.println(solution(Long.parseLong(min), Long.parseLong(max)));
    }

    public static int solution (long min, long max) {
        int answer = 0;

        boolean[] squareCheck = new boolean[(int)(max - min) + 1];

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long start = (((min - 1) / (i * i)) + 1) * (i * i);
            for (long j = start; j <= max; j += i * i) {
                squareCheck[(int)(j - min)] = true;
            }
        }

        for (boolean b : squareCheck) {
            if (!b) answer++;
        }
        return answer;
    }
}