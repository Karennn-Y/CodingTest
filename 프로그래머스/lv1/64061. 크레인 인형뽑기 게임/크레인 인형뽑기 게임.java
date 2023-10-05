import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> pullList = new Stack<>();
        int cnt = 0;
        for (int move : moves) {
            int idx = move - 1;
            for (int j = 0; j < board[idx].length; j++) {
                int n = board[j][idx];
                if (n != 0) {
                    if (!pullList.isEmpty() && pullList.peek() == n) {
                        cnt += 2;
                        pullList.pop();
                        board[j][idx] = 0;
                        break;
                    }
                    pullList.add(n);
                    board[j][idx] = 0;
                    break;
                }
            }
        }
        return cnt;
    }
}