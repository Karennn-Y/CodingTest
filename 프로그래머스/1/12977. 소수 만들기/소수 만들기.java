import java.util.*;

class Solution {
    public int solution(int[] nums) {
         Arrays.sort(nums);
        int max = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        int cnt = 0;

        boolean[] primeList = findPrime(max);

        for (int i = 0; i < nums.length - 2; i++)
            for (int j = i + 1; j < nums.length - 1; j++)
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (primeList[sum]) cnt++;
                }
        return cnt;
    }
    
    public boolean[] findPrime(int max) {
        boolean[] primeList = new boolean[max + 1];
        Arrays.fill(primeList, true);

        primeList[0] = false;
        primeList[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (primeList[i])
                for (int j = i * i; j <= max; j += i)
                    primeList[j] = false;
        }
        return primeList;
    }
}