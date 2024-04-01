import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        HashMap<String, Integer> words = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = bf.readLine();
            if (word.length() < m)
                continue;
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        List<String> keys = new ArrayList<>(words.keySet());

        keys.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Objects.equals(words.get(o1), words.get(o2))) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return words.get(o2) - words.get(o1);
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (String key : keys) {
            bw.write(key + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}