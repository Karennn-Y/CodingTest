import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> sums = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!sums.contains(sum))
                    sums.add(sum);
            }
        }
        Collections.sort(sums);
        return sums;
    }
}