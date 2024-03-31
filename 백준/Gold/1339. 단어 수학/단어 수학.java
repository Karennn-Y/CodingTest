import java.io.*;
import java.util.*;

public class Main {
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());

        for (int i = 0; i < cnt; i++)
            setWordCnt(bf.readLine());

        Arrays.sort(alphabet);

        int num = 9;
        int answer = 0;

        for (int i = 25; i >= 0; i--) {
            if (alphabet[i] == 0)
                break;
            answer += (alphabet[i] * num);
            num--;
        }
        System.out.println(answer);
    }

    public static void setWordCnt(String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            alphabet[c - 65] += (int) ((Math.pow(10, length - i)) / 10);
        }
    }
}