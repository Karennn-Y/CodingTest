import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> c1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> c2 = new ArrayList<>(Arrays.asList(cards2));
        int cnt = 0;
        
        for(String s : goal) {
            if (!c1.isEmpty() && s.equals(c1.get(0))) {
                c1.remove(0);
                cnt++;
            }
            else if (!c2.isEmpty() && s.equals(c2.get(0))) {
                c2.remove(0);
                cnt++;
            }
        }
        return cnt == goal.length ? "Yes" : "No";
    }
}