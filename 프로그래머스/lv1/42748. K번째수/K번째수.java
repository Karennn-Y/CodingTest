import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1] - 1;
            int[] arr = new int[end - start + 1];
            int idx2 = 0;
            for (int j = start; j <= end; j++) {
                arr[idx2++] = array[j];
            }
            Arrays.sort(arr);
            answer[idx] = arr[command[2] - 1];
            idx++;
        }
        return answer;
    }
}