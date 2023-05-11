import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> integerSet = new HashSet<>();
        int size = 1; 
        int length = elements.length;
        
        while (size <= length) {
            for (int i = 0; i < length; i++) {
                int number = 0;
                for (int j = i; j < size + i; j++) {
                    number += elements[j % length];
                }
                integerSet.add(number);
            }
            size++;
        }
        return integerSet.size();
    }
}