import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        int cnt = 0;

        first : for (int i = 0; i < test; i++) {
            HashSet<Character> alphabets = new HashSet<>();
            String check = sc.nextLine();
            char previous = ' ';
            for (char c : check.toCharArray()) {
                if(previous == ' ') {
                    alphabets.add(c);
                    previous = c;
                } else if (previous != c && alphabets.contains(c)) {
                    continue first;
                } else if (previous != c && !alphabets.contains(c)) {
                    previous = c;
                    alphabets.add(c);
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}