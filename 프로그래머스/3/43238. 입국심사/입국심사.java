import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * n;
        long minimum = 0;

        while (left <= right) {
            long middle = (left + right) / 2;
            long completed = 0;

            for (int time : times)
                completed += (middle / time);

            if (completed < n) {
                left = middle + 1;
                continue;
            }
            minimum = middle;
            right = middle - 1;
        }
        return minimum;
    }
}