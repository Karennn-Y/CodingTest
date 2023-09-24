import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> countMap = new HashMap<>();
        
        for (String p : participant) 
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
        
        for (String c : completion)
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        
        for(String name : countMap.keySet()) 
            if (countMap.get(name) % 2 != 0) return name;
        
        return null;
            
    }
}