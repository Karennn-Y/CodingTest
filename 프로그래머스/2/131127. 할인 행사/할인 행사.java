import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wishList = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> saleList = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                saleList.put(discount[i + j], 
                             saleList.getOrDefault(discount[i + j], 0) + 1);
            }
            
            boolean flag = true;
            
            for (String key : wishList.keySet()) {
                if (!Objects.equals(wishList.get(key), saleList.get(key))) {
                    flag = false;
                    break;
                }
            }
            answer += (flag) ? 1 : 0;
        }
        return answer;
    }
}