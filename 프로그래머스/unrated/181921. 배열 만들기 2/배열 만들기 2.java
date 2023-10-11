import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            String s = "";
            int cnt = 0;
            if (i % 5 == 0) {
                s = Integer.toString(i);
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != '0' && s.charAt(j) != '5') {
                        cnt++;
                        break;
                    }
                }
                if (cnt == 0)
                    list.add(i);
            }
        }
        
        if (list.isEmpty()) return new int[] {-1};
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}