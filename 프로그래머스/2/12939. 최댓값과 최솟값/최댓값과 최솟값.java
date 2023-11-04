import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String str : s.split(" "))
            numbers.add(Integer.parseInt(str));
            
        Collections.sort(numbers);
        
        return sb.append(numbers.get(0))
                     .append(" ")
                     .append(numbers.get(numbers.size() - 1)).toString();
    }
}