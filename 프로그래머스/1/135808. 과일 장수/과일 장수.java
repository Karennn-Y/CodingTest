import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int max = 0;
        Integer[] scoreIntegers = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreIntegers, Collections.reverseOrder());

        for (int i = 0; i < scoreIntegers.length; i += m) {
            if(i + m - 1 >= scoreIntegers.length)
                break;
            max += (scoreIntegers[i + m - 1] * m);
        }
        return max;
    }
}