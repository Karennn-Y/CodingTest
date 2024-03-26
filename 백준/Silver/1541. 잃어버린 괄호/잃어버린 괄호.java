import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bf.readLine().split("-");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("+")) {
                String[] nums = line.split("\\+");
                int tmp = 0;
                for (String n : nums) {
                    tmp += Integer.parseInt(n);
                }
                numbers.add(tmp);
            } else {
                numbers.add(Integer.parseInt(line));
            }
        }
        if (numbers.size() > 1) {
            int answer = numbers.get(0);

            for (int i = 1; i < numbers.size(); i++) {
                answer -= numbers.get(i);
            }

            System.out.println(answer);
        } else
            System.out.println(numbers.get(0));
    }
}