import java.util.*;

class Solution {
    static HashMap<String, Integer> setMenu;
    
    public static ArrayList<String> solution (String[] orders, int[] course) {
        for(int i =0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        ArrayList<String> answer = new ArrayList<>();

        for (int c : course) {
            setMenu = new HashMap<>();
            // 조합 만들기 -> course만큼 돌아서
            for (String order : orders) {
                String[] word = order.split("");
                if (word.length >= c) {
                    StringBuilder sb = new StringBuilder();
                    combination(word, sb, 0, c, 0);
                }
            }
            int max = Integer.MIN_VALUE;

            for (String menu : setMenu.keySet()) {
                max = Math.max(max, setMenu.get(menu));
            }

            for (String menu : setMenu.keySet()) {
                if (setMenu.get(menu) == max && max >= 2)
                    answer.add(menu);
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static void combination 
        (String[] word, StringBuilder sb, int start, int r, int count) {
        if (count == r) {
            setMenu.put(sb.toString(), 
                        setMenu.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < word.length; i++) {
            sb.append(word[i]);
            combination(word, sb, i + 1,  r, count + 1);
            sb.delete(count, count + 1);
        }
    }
}