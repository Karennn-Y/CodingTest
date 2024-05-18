import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> closet = new HashMap<>();
        
        for (String[] c : clothes) {
            closet.put(c[1], closet.getOrDefault(c[1], 0) + 1);
        }
        
        for (String key : closet.keySet())
            answer *= (closet.get(key) + 1);
        
        return answer - 1;
    }
}