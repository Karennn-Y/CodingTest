class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) 
            answer += (count(i) > 0) ? i : i * -1;
        return answer;
    }
    
    public int count(int num) {
        int cnt = 0;
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) cnt++;
            else if (num % i == 0) cnt += 2;
        }
        return (cnt % 2 == 0) ? cnt : cnt * -1;
    }
}