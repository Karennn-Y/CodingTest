import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            bw.write(solution(s) + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    public static String solution (String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            Stack<String> box = new Stack<>();
            for (String w : word.split(""))
                box.push(w);
            while (!box.isEmpty())
                sb.append(box.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}