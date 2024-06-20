import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = setDictionary();
        ArrayList<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        String[] words = msg.split("");
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            tmp = sb.toString();
            for (int j = i + 1; j < words.length; j++) {
                sb.append(words[j]);
                if (!dictionary.containsKey(sb.toString())) {
                    answer.add(dictionary.get(tmp));
                    dictionary.put(sb.toString(), dictionary.size() + 1);
                    sb.setLength(0);
                    tmp = "";
                    break;
                }
                tmp = sb.toString();
                i = j;
            }
            if (!tmp.equals(""))
                answer.add(dictionary.get(tmp));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public HashMap<String, Integer> setDictionary() {
        HashMap<String, Integer> dictionary = new HashMap<>();
        int idx = 1;

        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), idx++);
        }

        return dictionary;
    }
}