import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int previous = -1;
        for (int n : arr) {
            if (n != previous) 
                numbers.add(n);
            previous = n;
        }
        
        int[] answer = new int[numbers.size()];
        int idx = 0;
        for(int i : numbers)
            answer[idx++] = i;
        
        return answer;
    }
}