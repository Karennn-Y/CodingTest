import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        int answer = 0;
        
        Arrays.sort(lost);
        for (int i : reserve) {
            students[i - 1]++;
        }

        for (int i : lost) {
            students[i - 1]--;
        }

        for (int i = 0; i < n; i++) {
            if (students[i] < 0) {
                if (i > 0 && students[i - 1] > 0) {
                    students[i]++;
                    students[i - 1]--;
                } else if (i < n - 1 && students[i + 1] > 0) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }
        
        for (int i = 0; i < n; i++)
            if (students[i] >= 0)
                answer++;

        return answer;
    }
}