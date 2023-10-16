import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
       int sum = 1;
        for (int i = 1; i < number; i++) {
            int cnt = getDivisor(i + 1);
            sum = (cnt > limit) ? sum + power : sum + cnt;
        }
        return sum;
    }
    
    public int getDivisor(int number) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (number / i == i) cnt++;
                else cnt += 2;
            }
        }
        return cnt;
    }
}