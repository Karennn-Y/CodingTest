import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        ArrayList<Integer> top = new ArrayList<>();
        int score1 = getScore(s1, answers);
        int score2 = getScore(s2, answers);
        int score3 = getScore(s3, answers);

        int max = Math.max(score1, Math.max(score2, score3));
        if (max == score1)
            top.add(1);
        if (max == score2)
            top.add(2);
        if (max == score3)
            top.add(3);

        return top;
    }
    
    public int getScore(int[] scores, int[] answers) {
        int cnt = 0;
        int length = scores.length;
        for (int i = 0; i < answers.length; i++) {
            if (scores[i % length] == answers[i]) cnt++;
        }
        return cnt;
    }
}