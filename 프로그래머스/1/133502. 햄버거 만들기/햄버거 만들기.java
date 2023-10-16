import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        ArrayList<Integer> burger = new ArrayList<>();
        int cnt = 0;
        
        for (int i : ingredient) {
            if (i == 1 && burger.size() >= 3) {
                boolean flag = checkCount(burger);
                if (flag) cnt++;
                else burger.add(i);
            }
            else burger.add(i);
        }
        return cnt;
    }
    
    public boolean checkCount(ArrayList<Integer> burger) {
        int len = burger.size();
        if (burger.get(len - 1) == 3 && burger.get(len - 2) == 2 && burger.get(len - 3) == 1){
            burger.remove(len - 1);
            burger.remove(len - 2);
            burger.remove(len - 3);
            return true;
        }
        return false;
    }
}