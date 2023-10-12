import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> fame = new ArrayList<>();
        if (k > score.length) k = score.length;

        for(int i = 0; i < k; i++) {
            fame.add(score[i]);
            Collections.sort(fame);
            answer[i] = fame.get(0);
        }

        for (int i = k; i < score.length; i++) {
            if(fame.get(0) < score[i]) {
                fame.set(0, score[i]);
                Collections.sort(fame);
            }
            answer[i] = fame.get(0);
        }
        return answer;
    }
}