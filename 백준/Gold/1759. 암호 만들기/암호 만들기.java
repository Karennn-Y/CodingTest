import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<String> words = new ArrayList<>();
    static List<String> passwords = new ArrayList<>();
    static String[] letters;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] first = bf.readLine().split(" ");
        int l = Integer.parseInt(first[0]);
        int c = Integer.parseInt(first[1]);
        letters = bf.readLine().split(" ");
        Arrays.sort(letters);

        visited = new boolean[c];

        combination(0, c, l);

        for (String word : words)
            checkVowel(word);

        for (String password : passwords)
            System.out.println(password);
    }

    public static void combination(int start, int n, int r) {
        if(r == 0) {
            addList(n);
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    public static void addList(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <  n; i++) {
            if (visited[i])
                sb.append(letters[i]);
        }
        words.add(sb.toString());
    }

    public static void checkVowel(String s) {
        int vowel = 0;
        int consonant = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                    vowel++;
                    break;
                default:
                    consonant++;
                    break;
            }
        }
        if (vowel > 0 && consonant > 1)
            passwords.add(s);
    }
}