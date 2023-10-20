import java.util.Arrays;

class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] wall = new boolean[n];
        Arrays.fill(wall, true);
        for(int i : section) {
            wall[i - 1] = false;
        }
        int cnt = 0;
        for (int i = 0; i < wall.length; i++) {
            if(i + m > wall.length && !wall[i]) {
                cnt++;
                break;
            }
            if (!wall[i]) {
                for (int j = 0; j < m; j++) {
                    wall[i + j] = true;
                }
                i += m - 1;
                cnt++;
            }
        }
        return cnt;
    }
}