class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero_cnt = 0, cnt = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero_cnt++;
                continue;
            }
            for (int win_num : win_nums) {
                if (win_num == lotto) {
                    cnt++;
                    break;
                }
            }
        }
        return new int[]{7 - Math.max(cnt + zero_cnt, 1), 7 - Math.max(cnt, 1)};
    }
}