import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);

        ArrayList<Integer> tangerines = new ArrayList<>();

        int cnt = 1;
        int number = tangerine[0];

        for(int i = 1; i < tangerine.length; i++) {
            if(number != tangerine[i]) {
                tangerines.add(cnt);
                number = tangerine[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        tangerines.add(cnt);

        tangerines.sort(Collections.reverseOrder());
   
        int answer = 0;
        for (int t : tangerines) {
            answer++;
            k -= t;
            if (k <= 0) {
                break;
            }
        }
        return answer;
        
    }
}