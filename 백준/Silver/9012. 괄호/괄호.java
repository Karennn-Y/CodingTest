import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        for (int i = 0; i < cnt; i++) {
            String s = bf.readLine();
            Stack<String> box = new Stack<>();
            if(s.startsWith(")")) {
                System.out.println("NO");
                continue;
            }
            for (String str : s.split("")) {
                if (!box.isEmpty() && str.equals(")") && box.peek().equals("("))
                    box.pop();
                else
                    box.push(str);
            }
            if (box.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}