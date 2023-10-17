import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            if (s.contains("push")) {
                String n = s.split(" ")[1];
                stack.push(n);
            } else {
                switch (s) {
                    case "top" : {
                        if (stack.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(stack.peek());
                        }
                        break;
                    }
                    case "size" : {
                        System.out.println(stack.size());
                        break;
                    }
                    case "empty" : {
                        if (stack.isEmpty())
                            System.out.println(1);
                        else
                            System.out.println(0);
                        break;
                    }
                    case "pop" : {
                        if (stack.isEmpty())
                            System.out.println(-1);
                        else
                            System.out.println(stack.pop());
                        break;
                    }
                }
            }
        }
    }
}