import java.util.Arrays;

class Solution {
    public int getGCD (int num1, int num2) {
        int tmp = 0;
        while (num1 != 0) {
            tmp = num2 % num1;
            num2 = num1;
            num1 = tmp;
        }
        return num2;
    }
    
    public int solution(int[] arr) {
        
        int num1 = 0;
        int num2 = 0;
        int lcm = 0;
    
        Arrays.sort(arr);
        
        lcm = (arr[0] * arr[1]) / getGCD(arr[0], arr[1]);
        
        if (arr.length == 2) return lcm;
        
        for (int i = 2; i < arr.length; i++) {
            if (lcm > arr[i]) {
                num1 = arr[i];
                num2 = lcm;
            } else {
                num1 = lcm;
                num2 = arr[i];
            }
            
            lcm = (num1 * num2) / getGCD(num1, num2);
        }
        return lcm;
    }
}