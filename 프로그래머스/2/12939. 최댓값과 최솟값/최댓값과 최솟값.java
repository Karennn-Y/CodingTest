import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] nums = s.split(" ");
        
        for (String str : nums)
            numbers.add(Integer.parseInt(str));
            
        Collections.sort(numbers);
        
        return sb.append(Integer.toString(numbers.get(0)))
                     .append(" ")
                     .append(Integer.toString(numbers.get(numbers.size() - 1))).toString();
    }
}
