import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                answer[i] = -1;
                index.put(c, i);
            } else {
                int idx = index.get(c);
                answer[i] = i - idx;
                index.put(c, i);
            }
        }
        return answer;
    }
}